package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by vanqyard on 2/3/15.
 */
public class ConversationScreen extends JPanel {
    private JPanel mineTextScrollPanel = new JPanel(new BorderLayout());
    private JPanel peerTextScrollPanel = new JPanel(new BorderLayout());
    private JButton sendButton = new JButton("Send");
    public ConversationScreen() {
        setLayout(new BorderLayout());

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
                peerTextArea.append(text);
                mineTextArea.setText("");
            }
        });
    }
}
