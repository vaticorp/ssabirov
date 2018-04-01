package ru.job4j.db;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * This class represents EntriesUnparse
 * @author Svyatoslav Sabirov.
 * @since 01.04.2018
 * @version 12.
 */
@XmlRootElement(name = "entries")
public class EntriesUnparse {

    private List<EntryUnparse> entries;

    @XmlElement(name = "entry")
    public void setField(List<EntryUnparse> entries) {
        this.entries = entries;
    }

    public List<EntryUnparse> getField() {
        return entries;
    }
}

@XmlRootElement
class EntryUnparse {

    private int field;

    public int getField() {
        return field;
    }
    @XmlAttribute(name = "field")
    public void setField(int field) {
        this.field = field;
    }
}

