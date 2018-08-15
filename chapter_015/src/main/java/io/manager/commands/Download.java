package io.manager.commands;

import io.manager.BaseSocket;
import io.manager.PropertyStorage;
import io.manager.inputs.Input;

import java.io.*;

/**
 * This class represents class for download file.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class Download extends BaseCommand {

    public Download(int key, String name) {
        super(key, name);
    }

    @Override
    public void executeServer(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        String fileName = "";
        try {
            fileName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(String.format("%s\\%s",baseSocket.getPropertyStorage().getInitialFolder(), fileName));
        try(DataOutputStream dos = new DataOutputStream(baseSocket.getSocket().getOutputStream());
            FileInputStream fis = new FileInputStream(file);) {
            dos.writeInt((int) file.length());
            while (true) {
                byte[] buffer = new byte[1024];
                Integer len = fis.read(buffer);
                if(len == -1) {
                    break;
                }
                dos.write(buffer, 0, len);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeClient(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        String source = baseSocket.getInput().ask("Какой файл скачать с сервера: ");
        out.println(source);
        String dest = baseSocket.getInput().ask("Куда скачать файл: ");
        File file = new File(dest);
        try (DataInputStream dis = new DataInputStream(baseSocket.getSocket().getInputStream());
             FileOutputStream fos = new FileOutputStream(file);) {
            int i = 0;
            byte[] buffer = new byte[1024];
            Integer fileSize = dis.readInt();
            while (i < fileSize) {
                int len = dis.read(buffer);
                i += len;
                fos.write(buffer, 0, len);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
