package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Server server;
    private String login;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        writer = new PrintWriter(output, true);
    }

    @Override
    public void run() {
        System.out.println("Client connected");
        String message;
        try {
            writer.println("Podaj login:");
            String login = reader.readLine();
            writer.println("Podaj hasło:");
            String haslo = reader.readLine();
            boolean check = server.database.authenticate(login, haslo);
            if (check == false){
                writer.println("Błędne hasło");
                socket.close();
                server.removeClient(this);
            }
            this.login = login;
            while ((message = reader.readLine()) != null)
                writer.println(message);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client disconnected");

    }
}
