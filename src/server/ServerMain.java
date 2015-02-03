package server;

/**
 * Created by vanqyard on 2/2/15.
 */

import java.net.*;
import java.io.*;

public class ServerMain {
    private ServerSocket server;
    private int port = 7777;

    public ServerMain() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerMain example = new ServerMain();
        example.handleConnection();
    }

    public void handleConnection() {
        System.out.println("Waiting for client message...");

        //
        // The server do a loop here to accept all connection initiated by the
        // client application.
        //
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





/*
        ObjectOutputStream out
                = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream in
                = new ObjectInputStream(connection.getInputStream());
*/
}





