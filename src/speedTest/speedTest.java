package speedTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class speedTest {

    static void main() {
        try {
//            test(new String(""));
            test(new StringBuffer(""));
            test(new StringBuilder(""));
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }

        //        long startTime = System.nanoTime();
//        // Неоптимальный подход
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            list.add("Item " + i);
//        }
//        long estimatedTime = System.nanoTime() - startTime;
//        System.out.println(estimatedTime);
//
//        // Оптимизированный подход с известным размером
//        startTime = System.nanoTime();
//        List<String> optimizedList = new ArrayList<>(10000);
//        for (int i = 0; i < 1000000; i++) {
//            optimizedList.add("Item " + i);
//        }
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println(estimatedTime);
    }

    private static void test(Appendable obj) throws java.io.IOException {
        // узнаем текущее время до теста
        long before = System.currentTimeMillis();
        for (int i = 0; i++ < 1e9; ) {
            obj.append("");
        }
        // узнаем текущее время после теста
        long after = System.currentTimeMillis();
        // выводим результат
        System.out.println(obj.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }

}
