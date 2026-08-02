3 Things to get a Client working
1. Connecting
2. Sending
3. Receiving

Connecting
-----------
InetSocketAddress serverAddress = new InetSocketAddress("196.164.1.103", 5000);
SocketChannel socketChannel = SocketChannel.open(serverAddress);
// We don't use a constructor to createa new SocketChannel, we call the static open() method.
// This will create a new SocketChannel and connect it to the address you give it

Receive
--------

1. Make connection to the Server
// 127.0.0.1 is the IP address for the computer, this code is running on.
SocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 5000);
SocketChannel socketChannel = SocketChannel.open(serverAddr);
// I created a socketChannel that connects to this address.

2. Create or get a Reader from the connection
// Reader is a "bridge" between a low-level byte stream and high-level character stream.
Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
// We can use static helper methods on the Channels class to create a Reader from SocketChannel

3. Make a BufferedReader and read!
BufferedReader bufferedReader = new BufferedReader(reader);
String message = bufferedReader.readLine();
// Instead of new BufferedReader(new FileReader(file)) we are using ChannelReader


Sending
--------

1. Make connection to the Server
// Exactly same as Receiving
SocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 5000);
SocketChannel socketChannel = SocketChannel.open(serverAddr);

2. Create or get Writer from the connection
// Writer acts as a bridge between character data and bytes to be written to the channel
Writer writer = Channels.newWriter(socketChannel, StandardCharsets.UTF_8);
// Charset should be the same as used for reading

3. Make a PrintWriter and write (print) something
// PrintWriter is used when we are writing one string at a time
PrintWriter printWriter = new PrintWriter(writer);
writer.println("message to send");
writer.print("another message");
