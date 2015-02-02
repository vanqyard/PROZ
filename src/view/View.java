package view;

/**
 * Created by vanqyard on 2/2/15.
 */
import controller.ProgramEvent;
import java.util.concurrent.BlockingQueue;

public class View extends AbstractView {
    private final BlockingQueue<ProgramEvent> blockingQueue;

    public View(final BlockingQueue<ProgramEvent> blockingQueue) {
        this.blockingQueue = blockingQueue;



    }
}
