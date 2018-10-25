package com.oksana.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Component
public class PhotoSaver {
    public void savePhoto(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/img/photoOnSite/"
                                + formatInputtedText(file.getOriginalFilename(), file))));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("file cannot be saved");
            }
        }
    }

    public String formatInputtedText(String inputtedText, MultipartFile file) {

        return String.valueOf((inputtedText+String.valueOf(new Date())).hashCode())+
                "."+ FilenameUtils.getExtension(file.getOriginalFilename());
    }
}

