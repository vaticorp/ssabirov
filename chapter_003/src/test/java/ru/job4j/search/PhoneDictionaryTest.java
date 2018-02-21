package ru.job4j.search;


/**
 * This is test-class for PhoneDictionaryTest.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 18.02.2018
 */
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("et");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}