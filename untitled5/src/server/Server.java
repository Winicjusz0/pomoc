package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clientList = new ArrayList<>();
    public Database database = new Database();

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listen();
    }

    public void listen() throws IOException {
        serverSocket = new ServerSocket(3000);
        while(true){
            System.out.println("Server started");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            ClientHandler client = new ClientHandler(socket, this);
            addClient(client);
        }
    }

    public void addClient(ClientHandler client){
        clientList.add(client);
    }

    public void removeClient(ClientHandler client){
        clientList.remove(client);
    }
}