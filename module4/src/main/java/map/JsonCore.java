package map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class JsonCore {

    public <T> T getObject(String json, Class<T> clazz) throws Exception {
        String[] tokens = json.replace("{", "").replace("}", "")
                .replace("\"", "")
                .split(",");
        HashMap<String, Object> map = new HashMap<>();
        for (String token : tokens) {
            String[] keys = token.split(": ");
            map.put(keys[0], keys[1]);
        }
        System.out.println(map);
        Field[] fields = clazz.getDeclaredFields();
        Object o = clazz.getConstructor().newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            if (map.containsKey(field.getName())) {
                field.set(o, map.get(field.getName()));
            }
        }
        return (T) o;
    }
}
