package events;

/**
 * Created by vanqyard on 2/3/15.
 */
public class ReceiveEvent extends ProgramEvent {
    private final String text;

    public ReceiveEvent(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }
}
