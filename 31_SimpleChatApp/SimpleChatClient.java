// New and improved SimpleChatClient. Improved from SimpleChatClientA

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClient {
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;

    public void go() {
        setUpNetworking();

        JScrollPane scroller = createScrollableTextArea();
        
        outgoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        // This is the main addition from SimpleChatClientA in this method. 
        // There are other additions in other methods.
        // Here we just need one more thread to read messages.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new IncomingReader());

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    private JScrollPane createScrollableTextArea() {
        // A helper method, to create a scrolling text area.
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private void setUpNetworking() {
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
            SocketChannel socketChannel = SocketChannel.open(serverAddress);

            reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
        
            System.out.println("Networking established.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public class IncomingReader implements Runnable {
        public void run() { // This is what the thread does.
            String message;
            try {
                // It stays in a loop as long as what it gets from server is not null.
                while((message = reader.readLine()) != null) {
                    System.out.println("read " + message); // print to console
                    incoming.append(message + "\n"); // print to JTextArea (incoming is a JtextArea)
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
}