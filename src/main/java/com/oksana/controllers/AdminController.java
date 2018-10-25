package com.oksana.controllers;

import com.oksana.utils.SaveTxtFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class AdminController {
    private SaveTxtFile saveTxtFile;

    @Autowired
    public AdminController(SaveTxtFile saveTxtFile) {
        this.saveTxtFile = saveTxtFile;
    }

    @GetMapping("/login")
    public String getLoginG() {
        return "admin/login";
    }

    @PostMapping("/mainPageGallery")
    public String getGalleryPageAdmin() {
        return "admin/mainPageAdmin";
    }

    @RequestMapping("/")
    public String getHelloPage() {
        return "admin/helloOksana";
    }

    @RequestMapping("/adminPage")
    public String getAdminPage() {
        return "admin/adminPage";
    }

    @PostMapping("/infoAboutMe")
    public String getAboutMeRegPage() {
        return "admin/aboutMe";
    }

    @PostMapping("/addAboutMe")
    public String addAboutMe(@RequestParam("aboutMeText") String aboutMeText) {
        saveTxtFile.saveInfoFile(aboutMeText);
        return "admin/adminPage";
    }

    @PostMapping("/impressumAdmin")
    public String getImpressumRegPage() {
        return "admin/addImpressum";
    }

    @PostMapping("/addImpressum")
    public String addImpressum(@RequestParam("impressum") String impressum){
        saveTxtFile.saveImpressumFile(impressum);
        return "admin/adminPage";
    }

    @PostMapping("/contactsAdmin")
    public String getContactsRegPage() {
        return "admin/addContacts";
    }

    @PostMapping("/addContacts")
    public String addContacts(@RequestParam("contacts") String contacts){
        saveTxtFile.saveContactFile(contacts);
        return "admin/adminPage";
    }
}