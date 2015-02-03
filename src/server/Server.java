package server;

/**
 * Created by vanqyard on 2/2/15.
 */
import java.net.*;
import java.io.*;
import java.util.Date;

public class Server {
    int port = 2000;
    private static Server server;

    public Server() {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream());

                    Date now = new Date();
                    out.write(now.toString() +"\r\n");

                    out.flush();
                    connection.close();
                } catch (IOException ex) {}
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        server = new Server();

    }



}
