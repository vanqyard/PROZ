package client;

/**
 * Created by vanqyard on 2/2/15.
 */
import com.sun.corba.se.pept.encoding.InputObject;

import java.net.*;
import java.io.*;

public class Client {
    int port = 2000;
    String ipNumber = "127.0.0.1";

    public Client() {
        try( Socket socket = new Socket(ipNumber, port) ) {
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");

            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }

            System.out.println(time);




        } catch (IOException ex) {
        System.err.println("Could not connect to localhost");
    }


}





}


