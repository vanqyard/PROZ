package controller;

/**
 * Created by vanqyard on 2/2/15.
 */
import events.ProgramEvent;
import view.View;
import client.Client;
import java.util.concurrent.BlockingQueue;
import java.util.HashMap;
import java.util.Map;
import events.*;

public class Controller {
    /** kolejka na ProgramEvent'y **/
    final private BlockingQueue<ProgramEvent> blockingQueue;
    /**odwzorowanie obiektow ProgramEvent na obiekty ProgramAction*/
    private final Map<Class<? extends ProgramEvent>, ProgramAction> eventActionMap;
    final private Client client;
    final private View view;

    public Controller(final BlockingQueue<ProgramEvent> blockingQueue, Client client, View view) {
        eventActionMap = new HashMap<Class<? extends ProgramEvent>, ProgramAction>();
        this.blockingQueue = blockingQueue;
        this.client = client;
        this.view = view;

        fillEventActionMap();
    }

    /**
     * zapelnia kontener eventActionMap
     */
    private void fillEventActionMap() {
        eventActionMap.put(SendEvent.class, new ProgramAction() {
            public void go(ProgramEvent e){
                SendEvent event = (SendEvent)e;
                String message = event.getMessage();
                client.sendMessage();

                System.out.println("client sent message");
            }
        });

        eventActionMap.put(ReceiveEvent.class, new ProgramAction() {
            public void go(ProgramEvent e) {
                ReceiveEvent event = (ReceiveEvent)e;
                String message = event.getMessage();
                view.printMessage(message);

                System.out.println("client receive message");
            }
        });

    }

    /**
     * funkcja obsligujca komunikaty z widoku w nieskonczonej petki
     * <br> tzn pobieajaca obiekt z kolejki(blockingQueue) i na jego podstawie uruchamiajaca
     * odpowiednie dzialannie z mapy zadan(eventActionMap)
     * <br>-normalne dzialanie kontrolera :)
     */
    public void work(){
        while(true){
            try{
                ProgramEvent event = blockingQueue.take();
                ProgramAction saperAction = eventActionMap.get(event.getClass());
                saperAction.go(event);
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
