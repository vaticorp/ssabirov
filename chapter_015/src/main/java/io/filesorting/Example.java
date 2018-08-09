package io.filesorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Example {
    public void ex(File source) throws FileNotFoundException {
        try(Scanner scanner = new Scanner( new BufferedInputStream( new FileInputStream( source )));
            PrintStream  lower   = new PrintStream(  new BufferedOutputStream( new FileOutputStream( new File("D:\\test\\sort\\second.txt"), true )));) {
            while ( scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println(str);
                lower.print(str + "\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Example().ex(new File("D:\\test\\sort\\first.txt"));
    }
}
