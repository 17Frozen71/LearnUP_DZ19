package event;

import org.springframework.context.ApplicationEvent;

public class testEvent extends ApplicationEvent {
    public testEvent(Object source) {
        super(source);
    }
    public static testEvent of(String english,String russian) {
        return new testEvent(new eventData(english,russian));
    }
}
