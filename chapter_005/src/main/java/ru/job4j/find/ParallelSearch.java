package ru.job4j.find;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


@ThreadSafe
public class ParallelSearch extends SimpleFileVisitor<Path> {

    private final String root;
    private final String text;
    private final List<String> exts;
    private volatile boolean finish = false;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String stringFile = file.toString();
        for (String ext : exts) {
            if (stringFile.contains(ext)) {
                System.out.println("Поток отобрал файл: " + Thread.currentThread().getName());
                files.add(stringFile);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public void init() {
        ParallelSearch current = this;
        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    Files.walkFileTree(Paths.get(root), current);
                    finish = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                synchronized (files) {
                    while (!finish || files.size() > 0) {
                        if (files.size() > 0) {
                            String path = files.poll();
                            System.out.println("Поток сканирует новый файл: " + Thread.currentThread().getName());
                            try (FileInputStream fis = new FileInputStream(new File(path));) {
                                byte[] content = new byte[fis.available()];
                                fis.read(content);
                                fis.close();
                                String[] lines = new String(content, "Cp1251").split("\n");
                                for (String line : lines) {
                                    String[] words = line.split(" ");
                                    int j = 1;
                                    for (String word : words) {
                                        if (word.equals(text)) {
                                            paths.add(path);
                                        }
                                    }
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        read.start();
        search.start();
    }

    synchronized List<String> result() {
        return this.paths;
    }
}
