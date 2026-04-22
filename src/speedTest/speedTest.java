package speedTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class speedTest {

    static void main() {

        long startTime = System.nanoTime();
        // Неоптимальный подход
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add("Item " + i);
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);

        // Оптимизированный подход с известным размером
        startTime = System.nanoTime();
        List<String> optimizedList = new ArrayList<>(10000);
        for (int i = 0; i < 1000000; i++) {
            optimizedList.add("Item " + i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
    }
}
