package com.oksana.utils;

import com.oksana.entities.Tail;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PhotoDeleter {

    public boolean deleteFile(Tail tail){
       return new File("src/main/resources/static/img/photoOnSite/"+tail.getPathToFile()).delete();
    }
}
