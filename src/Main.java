/**
 * Created by vanqyard on 2/2/15.
 */
import events.ProgramEvent;
import view.View;
import controller.Controller;
import client.Client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    private static Client client;
    private static View view;
    private static final BlockingQueue<ProgramEvent> blockingQueue
            = new LinkedBlockingDeque<ProgramEvent>();

    public static void main(String[] args) {

        //view = new View(blockingQueue);
        client = new Client(blockingQueue);
        //Controller controller = new Controller(blockingQueue, client, view);

        //controller.work();

        client.sendMessage();

    /*
        System.out.println("=== RunnableTest ===");

         // Anonymous Runnable
        Runnable r1 = new Runnable(){

            @Override
            public void run(){
                    System.out.println("Hello world one!");
            }
        };

        // Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        // Run em!
        r1.run();
        r2.run();
    */
    }
}
