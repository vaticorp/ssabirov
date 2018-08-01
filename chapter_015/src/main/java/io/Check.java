package io;

import java.io.*;

/**
 * This class represents class for input-check;
 * @author Svyatoslav Sabirov.
 * @since 01.08.2018
 * @version 9.
 */
public class Check {
    public boolean isNumber(InputStream in) {
        int value = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));) {
            value = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (value % 2) == 0;
    }

    public static void main(String[] args) {
        Check check = new Check();
        System.out.println(check.isNumber(System.in));
    }
}
