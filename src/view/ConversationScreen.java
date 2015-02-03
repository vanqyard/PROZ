package view;

import events.ProgramEvent;
import events.SendEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vanqyard on 2/3/15.
 */
public class ConversationScreen extends JPanel {
    private final BlockingQueue<ProgramEvent> blockingQueue;
    private JPanel mineTextScrollPanel = new JPanel(new BorderLayout());
    private JPanel peerTextScrollPanel = new JPanel(new BorderLayout());
    private JButton sendButton = new JButton("Send");
    private String peerName = new String();

    public ConversationScreen(BlockingQueue<ProgramEvent> blockingQueue, String peerName) {
        this.blockingQueue = blockingQueue;
        setLayout(new BorderLayout());
        this.peerName = peerName;

        /* "=== textScrollPanel ===" */
        JTextArea mineTextArea = new JTextArea();
        JTextArea peerTextArea = new JTextArea();
        mineTextArea.setEditable(true);
        peerTextArea.setEditable(false);
        //mineTextArea.setSize(new Dimension(400, 400));
        //peerTextArea.setSize(new Dimension(400, 400));

        //textArea.setBorder(BorderFactory.createLoweredBevelBorder());

        JScrollPane mineTextScroller = new JScrollPane(mineTextArea);
        JScrollPane peerTextScroller = new JScrollPane(peerTextArea);
        mineTextScrollPanel.add(mineTextScroller, BorderLayout.CENTER);
        peerTextScrollPanel.add(peerTextScroller, BorderLayout.CENTER);
        mineTextScrollPanel.add(sendButton, BorderLayout.PAGE_END);

        /* "=== Create a split pane with the two scroll panes in it.===" */
        JSplitPane conversationSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                peerTextScrollPanel, mineTextScrollPanel);

        add(conversationSplitPane);

        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String text = mineTextArea.getText();

                peerTextArea.append("\n" + new Date() + " from " + peerName.toUpperCase() + ": \n" + text + "\n");
                mineTextArea.setText("");

                try {
                    blockingQueue.put(new SendEvent(text));
                } catch ( InterruptedException ex) {
                    throw new RuntimeException();
                }
            }
        });
    }
}
