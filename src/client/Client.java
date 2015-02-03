package client;

/**
 * Created by vanqyard on 2/2/15.
 */
import events.ProgramEvent;

import events.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;

public class Client {
    int port = 2000;
    String ipNumber = "localhost";
    private BlockingQueue<ProgramEvent> blockingQueue;

    ObjectOutputStream oos;
    ObjectInputStream ois;
    public Client(final BlockingQueue<ProgramEvent> blockingQueue) {
        this.blockingQueue = blockingQueue;

        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 7777);

            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("sending: Hello There...");

            ois = new ObjectInputStream(socket.getInputStream());

            while(true) {
                String message = (String) ois.readObject();

                if(message != null) {
                    System.out.println("received: " + message);
                }
            }






            //ois.close();
            //oos.close();
        } catch (IOException ex) {
            System.out.println("IOException");
            throw new RuntimeException();
        } catch (ClassNotFoundException  ex) {
            System.out.println("ClassNotFound");
            throw new RuntimeException();
        }
    }

    public void sendMessage() {
        try {
            oos.writeObject("Hello There...");

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}


