package controller;

/**
 * Created by vanqyard on 2/2/15.
 */
import java.util.concurrent.BlockingQueue;

public class Controller {
    final private BlockingQueue<ProgramEvent> blockingQueue;

    public Controller(final BlockingQueue<ProgramEvent> blockingQueue) {
        this.blockingQueue = blockingQueue;


    }

}
