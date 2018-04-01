package ru.job4j.db;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * This class represents Entries-xml.
 * @author Svyatoslav Sabirov.
 * @since 28.03.2018
 * @version 7.
 */
@XmlRootElement
public class Entries {
    private List<Entry> entries;

    @XmlElement(name = "entry")
    public void setField(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> getField() {
        return entries;
    }
}

@XmlRootElement
class Entry {
    private int field;

    public int getField() {
        return field;
    }

    @XmlElement
    public void setField(int field) {
        this.field = field;
    }
}
