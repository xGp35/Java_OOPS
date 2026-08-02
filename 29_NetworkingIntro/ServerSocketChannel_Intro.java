// Writing a Simple Server application

// Need 2 channels - ServerSocketChannel and ScoketChannel for communicaiton

1. Server application makes a ServerSocketChannel and binds it to a specific port

ServerSocketChannel serverChannel = ServerSocketChannel.open();
serverChannel.bind(new InetSocketAddress(5000));
// This starts the server application listening for client requests coming in for port 5000

2. Client makes a SocketChannel connected to the server application

SocketChannel svr = SocketChannel.open(new InetSocketAddress("190.165.1.103", 5000));

3. Server makes a new SocketChannel to communicate with this client

SocketChannel clientChannel = serverChannel.accept();
// So yes, clientChannel represents the server-side endpoint of the connection.
// The name clientChannel is actually a bit misleading—it means 
// "the channel for communicating with this client." It's not the client's channel; 
// it's the server's handle to the connection with that client. Many developers prefer names like:
SocketChannel socketToClient = serverChannel.accept();