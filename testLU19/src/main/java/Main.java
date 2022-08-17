import event.testEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        //Создаем переменные с хранящимися репликами и контекстом
        ResourceBundle resource_RU = ResourceBundle.getBundle("text");
        ResourceBundle resource_US = ResourceBundle.getBundle("text", Locale.US);
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        //Запускаем первое событие для вывода приветственого сообщения и сообщения с условиями
        context.publishEvent(testEvent.of(resource_US.getString("start"), resource_RU.getString("start")));
        context.publishEvent(testEvent.of(resource_US.getString("attempt"), resource_RU.getString("attempt")));

        //Создаем рандомное число и инициализируем сканер для дальнейшей работы
        int rnd = (int) (Math.random() * 1000);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(rnd);

        //Далее идет простой алгоритм, который работает пока не отгадаем число, он подсказывает нужно ли увеличить/уменьшить число
        while (a != rnd) {
            if (a < rnd)
                context.publishEvent(testEvent.of(resource_US.getString("more"), resource_RU.getString("more")));
            else
                context.publishEvent(testEvent.of(resource_US.getString("less"), resource_RU.getString("less")));
            a = sc.nextInt();
        }

        //Вывод сообщения о победе в игре
        context.publishEvent(testEvent.of(resource_US.getString("victory") + rnd, resource_RU.getString("victory") + rnd));

    }
}
