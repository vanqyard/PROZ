package server;

/**
 * Created by vanqyard on 2/3/15.
 */

import java.net.*;
import java.io.*;

class ConnectionHandler implements Runnable {
    private Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try
        {
            //
            // Read a message sent by client application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("srv received: " + message);

            //
            // Send a response information to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi...");

            ois.close();
            oos.close();
            socket.close();

            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}