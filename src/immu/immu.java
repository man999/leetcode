import java.util.HashMap;
import java.util.Map;

void main() {
    Map<String, String> map = new HashMap<>();
    map.put("good key", "value");

    // Инициализация нашего "иммутабельного" класса
    AlmostMutableClass almostMutable = new AlmostMutableClass(
            "this is not immutable", map);

    // Мы не можем изменять состояние объекта
    // через добавление элементов в полученную map
    System.out.println("Result after modifying the map after we get it from the object");
    almostMutable.getFieldMap().put("bad key", "another value");
    almostMutable.getFieldMap().keySet().forEach(e -> System.out.println(e));

    System.out.println("Result of the object's map after modifying the initial map");
    map.put("bad key", "another value");
    almostMutable.getFieldMap().keySet().forEach(e -> System.out.println(e));
}

public final class AlmostMutableClass {
    private String field;
    private Map<String, String> fieldMap;

    public AlmostMutableClass(String field, Map<String, String> fieldMap) {
        this.field = field;
        this.fieldMap = fieldMap;
    }

    public String getField() {
        return field;
    }

    public Map<String, String> getFieldMap() {
        Map<String, String> deepCopy = new HashMap<String, String>();
        for (String key : fieldMap.keySet()) {
            deepCopy.put(key, fieldMap.get(key));
        }
        return deepCopy;
    }
}
