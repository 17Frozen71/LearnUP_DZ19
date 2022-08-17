package logging;

public class logger {
    private final String prefix;

    public logger(String prefix) {
        this.prefix = prefix;
    }

    public void log(Object o){
        System.out.println("Log: " + prefix + o);
    }
}
