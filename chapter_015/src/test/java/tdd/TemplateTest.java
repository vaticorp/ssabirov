package tdd;

import org.junit.Test;
import tdd.exceptions.ExtraKeyException;
import tdd.exceptions.NoKeyException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TemplateTest {

    @Test
    public void whenWeHaveTwoKeyThenSuccess() {
        Template template = new SimpleGenerator();
        String text = "It ${preposition} very ${level} example";
        Map<String, String> map = new HashMap<>();
        map.put("preposition","is");
        map.put("level","easy");
        String checked = "It is very easy example";
        String result = template.generate(text, map);
        assertThat(checked, is(result));
    }

    @Test(expected = ExtraKeyException.class)
    public void whenWeHaveThreeKeyThenExceptionExtraKey() {
        Template template = new SimpleGenerator();
        String text = "It ${preposition} very ${level} example";
        Map<String, String> map = new HashMap<>();
        map.put("preposition","is");
        map.put("level","easy");
        map.put("name","Petr");
        String checked = "It is very easy example";
        String result = template.generate(text, map);
        assertThat(checked, is(result));
    }

    @Test(expected = NoKeyException.class)
    public void whenWeHaveOneKeyThenExceptionNoKey() {
        Template template = new SimpleGenerator();
        String text = "It ${preposition} very ${level} example";
        Map<String, String> map = new HashMap<>();
        map.put("preposition","is");
        String checked = "It is very easy example";
        String result = template.generate(text, map);
        assertThat(checked, is(result));
    }
}