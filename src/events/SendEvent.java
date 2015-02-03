package events;

/**
 * Created by vanqyard on 2/3/15.
 */
public class SendEvent extends ProgramEvent {
    private final String text;

    public SendEvent(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }
}
