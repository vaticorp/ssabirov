package io.archive;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class represents class for archive files.
 * @author Svyatoslav Sabirov.
 * @since 08.08.2018
 * @version 13.
 */
public class Archiver {

    private final String source_dir;
    private final String zip_file;
    private final String expandings;

    public Archiver(String source_dir, String zip_file, String expandings) {
        this.source_dir = source_dir;
        this.zip_file = zip_file;
        this.expandings = expandings;
    }

    private void zip() {
        try(FileOutputStream fout = new FileOutputStream(this.zip_file);
            ZipOutputStream zout = new ZipOutputStream(fout);) {
            File fileSource = new File(this.source_dir);
            addDirectory(zout, fileSource);
            System.out.println("Zip файл создан!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод рекурсивно добавляем каталоги и файли по нужным расширениям.
     * @param zout - архив.
     * @param fileSource - каталог(файл) для добавления в архив.
     * @throws Exception
     */
    private void addDirectory(ZipOutputStream zout, File fileSource) {
        File[] files = fileSource.listFiles();
        System.out.println(String.format("Добавление директории <%s>", fileSource.getName()));
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                addDirectory(zout, files[i]);
                continue;
            }
            String fileName = files[i].getName();
            String extension = FilenameUtils.getExtension(fileName);
            if (!this.expandings.contains(extension)) {
                continue;
            }
            System.out.println(String.format("Добавление файла <%s>", fileName));
            try (FileInputStream fis = new FileInputStream(files[i]);) {
                zout.putNextEntry(new ZipEntry(files[i].getPath()));
                byte[] buffer = new byte[4048];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Archiver archivator = new Archiver("D:\\test\\rom", "D:\\test\\result.zip", ".txt.xlsx");
        archivator.zip();
    }
}
