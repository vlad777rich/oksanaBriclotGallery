package com.oksana.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TextReader {
    public List<String> infoTextReader() {
        List<String> info = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/info/aboutMe.txt"))) {
            while (br.ready())
                info.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public List<String> impressumTextReader() {
        List<String> impressum = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/info/impressum.txt"))) {
            while (br.ready())
                impressum.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return impressum;
    }

    public List<String> contactsTextReader() {
        List<String> contact = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/info/contacts.txt"))) {
            while (br.ready())
                contact.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contact;
    }
}
