package cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * This class represents cache on soft-reference.
 * @author Svyatoslav Sabirov.
 * @since 17.07.2018
 * @version 7.
 */
public class Cache {

    private String folder;
    private HashMap<String, SoftReference> list = new HashMap<>();

    public Cache(String folder) {
        this.folder = folder;
    }

    public void add(String key, String value)  {
        System.out.println("Помещаем значение в кэш!");
        list.put(key, new SoftReference(value));
    }

    public void get(String key) throws IOException {
        SoftReference<String> value = list.get(key);
        String result = "";
        if (value == null) {
            result = Files.lines(Paths.get(String.format("%s\\%s",folder,key)), StandardCharsets.UTF_8).reduce((s1, s2) -> s1 + s2).get();
            add(key, result);
        } else {
            System.out.println("Получаем значение из кэша!");
            result = value.get();
        }
        System.out.println(result);
    }

    @Override
    public String toString() {
        return "Cache{" +
                "folder='" + folder + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        Cache cache = new Cache("D:\\test");
        cache.get("1.txt");
        cache.get("2.txt");
        cache.get("1.txt");
        cache.get("1.txt");
        cache.get("3.txt");
        cache.get("2.txt");
        cache.get("3.txt");
    }
}
