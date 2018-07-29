package tdd;

import java.util.Map;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 28.07.2018
 * @version 6.
 */
public interface Template {
    /**
     * Hello world, ${name}
     * @param template
     * @param data
     * @return
     */
    String generate(String template, Map<String, String> data);
}
