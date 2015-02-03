package view;

import controller.ProgramEvent;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vanqyard on 2/3/15.
 */
public class MenuBar extends JMenuBar {
    private final BlockingQueue<ProgramEvent> blockingQueue;
    private JMenuItem file = new JMenuItem("File");

    public MenuBar(final BlockingQueue<ProgramEvent> blockingQueue) {
        this.blockingQueue = blockingQueue;
        add(file);



    }

}
