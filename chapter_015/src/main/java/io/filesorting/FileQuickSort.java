package io.filesorting;

import java.io.*;
import java.util.*;

/**
 * This class represents class for sorting example.
 * @author Svyatoslav Sabirov.
 * @since 02.08.2018
 * @version 7.
 */
public class FileQuickSort implements Sorting {

    static final int MAX_SIZE = 1024*1024*16;

    public static void main( String [] args ) throws IOException {
        new FileQuickSort().sort( new File("D:\\test\\sort\\first.txt"), new File("D:\\test\\sort\\second.txt"));
        System.out.println();
    }

    @Override
    public void sort(File inputFile, File outputFile) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(inputFile)));) {
            if (inputFile.length() > MAX_SIZE && scanner.hasNextInt()) {
                File lowerFile = File.createTempFile("quicksort-", "-lower.tmp", new File("."));
                File greaterFile = File.createTempFile("quicksort-", "-greater.tmp", new File("."));
                try (PrintStream lower = new PrintStream(new BufferedOutputStream(new FileOutputStream(lowerFile, true)));
                     PrintStream greater = new PrintStream(new BufferedOutputStream(new FileOutputStream(greaterFile, true)));) {
                    PrintStream target = null;
                    String pivot = scanner.nextLine();
                    while (scanner.hasNextLine()) {
                        String current = scanner.nextLine();
                        if (current.length() < pivot.length()) {
                            target = lower;
                        } else {
                            target = greater;
                        }
                        target.print(String.format("%s\r\n",current));
                    }
                    greater.print(String.format("%s\r\n",pivot));
                    sort(lowerFile, outputFile);
                    lowerFile.delete();
                    sort(greaterFile, outputFile);
                    greaterFile.delete();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else {
                List<String> smallFileIntegers = new ArrayList<String>();
                while( scanner.hasNextLine() ){
                    smallFileIntegers.add( scanner.nextLine() );
                }
                smallFileIntegers.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return (o1.length() < o2.length()) ? -1: 1;
                    }
                });
                try(PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outputFile, true)));) {
                    smallFileIntegers.forEach(s -> out.print(String.format("%s\r\n",s)));
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
