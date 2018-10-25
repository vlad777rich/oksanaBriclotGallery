package com.oksana.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class SaveTxtFile {
    public void saveInfoFile(String text){
        if (!text.isEmpty()) {
            try {
                byte[] bytes = text.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/info/aboutMe.txt")));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("file cannot be saved");
            }
        }
    }
    public void saveImpressumFile(String text){
        if (!text.isEmpty()) {
            try {
                byte[] bytes = text.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/info/impressum.txt")));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("file cannot be saved");
            }
        }
    }

    public void saveContactFile(String contacts) {
        if (!contacts.isEmpty()) {
            try {
                byte[] bytes = contacts.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/info/contacts.txt")));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("file cannot be saved");
            }
        }
    }
}
