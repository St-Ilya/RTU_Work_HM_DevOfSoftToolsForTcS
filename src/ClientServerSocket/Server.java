package ClientServerSocket;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException{
        Server.ServerSoc();
    }

    public static void ServerSoc() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        serverSocket.accept();

        serverSocket.close();
    }
}
