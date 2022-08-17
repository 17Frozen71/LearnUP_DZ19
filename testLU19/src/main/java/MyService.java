import event.testEvent;
import logging.logger;
import org.springframework.context.ApplicationListener;
import java.util.List;

public class MyService implements ApplicationListener<testEvent> {

    private final List<logger> loggers;

    public MyService(List<logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void onApplicationEvent(testEvent event) {
        loggers.forEach(l -> {
            l.log(event);
        });
    }
}
