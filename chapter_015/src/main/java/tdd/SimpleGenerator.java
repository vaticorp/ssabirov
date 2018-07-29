package tdd;

import tdd.exceptions.ExtraKeyException;
import tdd.exceptions.NoKeyException;
import java.util.Map;

/**
 * This class represents simple class for working with strings.
 * @author Svyatoslav Sabirov.
 * @since 28.07.2018
 * @version 9.
 */
public class SimpleGenerator implements Template {

    @Override
    public String generate(String template, Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (!template.contains(String.format("${%s}", entry.getKey()))) {
                throw new ExtraKeyException("Лишние ключи!");
            }
            template = template.replace(String.format("${%s}", entry.getKey()), entry.getValue());
        }
        if (template.contains("${")) {
            throw new NoKeyException("Нет данных по ключу!");
        }
        return template;
    }

    /*    public String generate1(String snippet, Map<String, String> GREEK_LETTER_DICT) {
        return Arrays.stream(snippet.split(""))
                .map(c -> GREEK_LETTER_DICT.getOrDefault(c, c))
                .collect(Collectors.joining());
    }
    */
}
