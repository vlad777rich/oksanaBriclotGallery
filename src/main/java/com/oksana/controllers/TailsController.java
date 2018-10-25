package com.oksana.controllers;

import com.oksana.entities.Tail;
import com.oksana.services.TailService;
import com.oksana.utils.PhotoDeleter;
import com.oksana.utils.PhotoSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
public class TailsController {
    private TailService tailService;
    private PhotoSaver photoSaver;
    private PhotoDeleter photoDeleter;

    @Autowired
    public TailsController(PhotoSaver photoSaver, TailService tailService, PhotoDeleter photoDeleter) {
        this.photoSaver = photoSaver;
        this.tailService = tailService;
        this.photoDeleter = photoDeleter;
    }

    @PostMapping("/addNewPeople")
    public String addNewPeople() {
        return "admin/addNewPeopleForm";
    }

    @PostMapping("/addNewFood")
    public String addNewFood() {
        return "admin/addNewFoodForm";
    }

    @PostMapping("/regNewPeople")
    public String saveNewPeople(@ModelAttribute("story") Tail tail,
                                @RequestParam("file") MultipartFile file) {
        photoSaver.savePhoto(file);
        tail.setType("people");
        tail.setPathToFile(photoSaver.formatInputtedText(file.getOriginalFilename(), file));
        tail.setDateOfCreation(String.valueOf(new Date()));
        tailService.addTail(tail);
        return "admin/saveStory";
    }

    @PostMapping("/regNewFood")
    public String saveNewFood(@ModelAttribute("story") Tail tail,
                              @RequestParam("file") MultipartFile file) {
        photoSaver.savePhoto(file);
        tail.setType("food");
        tail.setPathToFile(photoSaver.formatInputtedText(file.getOriginalFilename(), file));
        tail.setDateOfCreation(String.valueOf(new Date()));
        tailService.addTail(tail);
        return "admin/saveStory";
    }

    @PostMapping("/listOfTails")
    public String getAllTails(Model model) {
        List<Tail> tails = tailService.getAllTails();
        model.addAttribute("tails", tails);
        return "tails/listOfTails";
    }

    @PostMapping("/deleteStory/{name}")
    public String deleteTail(@PathVariable("name") String name) {
        if (photoDeleter.deleteFile(tailService.getTailByName(name))) {
            tailService.deleteTailByName(name);
        }
        return "admin/deleteStory";
    }
    @PostMapping("/deleteAll")
    public String deleteAllTails() {

        List<Tail> tailsForDeleting;
        tailsForDeleting=tailService.getAllTails();
        for (Tail t : tailsForDeleting ){
            if(photoDeleter.deleteFile(tailService.getTailByName(t.getName()))){
                tailService.deleteTailByName(t.getName());
            }
        }
        return "admin/deleteStory";
    }
}