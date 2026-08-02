// We can do whatever we did using SocketChannel, with Socket objects too,
// package present in java.net.Socket
import java.net.Socket;

Socket chatSocket = new Socket("127.0.0.1", 5000);
// Read from Socket
InputStreamReader inReader = new InputStreamReader(chatSocket.getInputStream());

// Then we can read with Buffered Reader exactly how we read in SocketChannel
BufferedReader bufferedReader = new BufferedReader(inReader);
String message = bufferedReader.readLine();

// To write to a socket, we need to get an OutputStream from the Socket, which we 
// can chain to the PrintWriter
PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());

writer.println("message to send");
writer.print("another message");