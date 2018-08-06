package io.filesorting;

import java.io.File;
import java.io.IOException;

/**
 * This class represents interface for sorting file.
 * @author Svyatoslav Sabirov.
 * @since 02.08.2018
 * @version 9.
 */
public interface Sorting {
    void sort(File source, File distance) throws IOException;
}
