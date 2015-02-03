package view;

/**
 * Created by vanqyard on 2/2/15.
 */
import controller.ProgramEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.awt.event.*;

public class View extends AbstractView {
    private final BlockingQueue<ProgramEvent> blockingQueue;
    private JFrame frame = new JFrame();
    private JList list;
    private JPanel listScrollPanel = new JPanel(new BorderLayout());

    public View(final BlockingQueue<ProgramEvent> blockingQueue) {
        frame.setVisible(true);
        this.blockingQueue = blockingQueue;
        frame.setTitle("proz");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* "=== menuBar ===" */
        frame.setJMenuBar(new MenuBar(blockingQueue));

        /* "=== tabbedPane ===" */
        JTabbedPane tabbedPane = new JTabbedPane();

        /* "=== listScrollPanel ===" */
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        listModel.addElement("item 1");
        listModel.addElement("item 2");
        list = new JList(listModel);

        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 120));
        listScrollPanel.add(listScroller, BorderLayout.CENTER);

        listModel.addElement("Random");

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()){
                    JList source = (JList)event.getSource();
                    String selected = source.getSelectedValue().toString();

                    ConversationScreen conversationSplitPane = new ConversationScreen();
                    tabbedPane.addTab(selected, conversationSplitPane);
                }
            }
        });

        JButton button = new JButton("Dodaj");
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                listModel.addElement("new item");
            }
        });
        listScrollPanel.add(button, BorderLayout.PAGE_END);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                listScrollPanel, tabbedPane);

        frame.add(mainSplitPane);
    }
}
