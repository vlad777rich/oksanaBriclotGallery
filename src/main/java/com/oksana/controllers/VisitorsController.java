package com.oksana.controllers;

import com.oksana.entities.Tail;
import com.oksana.services.TailService;
import com.oksana.utils.TextReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VisitorsController {
    private TailService tailService;
    private TextReader textReader;

    @Autowired
    public VisitorsController(TailService tailService, TextReader textReader) {
        this.tailService = tailService;
        this.textReader = textReader;
    }

    @RequestMapping("/oksanaBriclot")
    public String getGalleryPage() {
        return "clientsPages/mainPageClients";
    }

    @RequestMapping("/productsPhoto")
    public String getProductsPhoto(Model model) {
        List<Tail> tails = tailService.getAllProductsByType("food");
        model.addAttribute("tails", tails);
        return "clientsPages/productsPhotos";
    }

    @RequestMapping("/peoplesPhoto")
    public String getPeoplesPhoto(Model model) {
        List<Tail> tails = tailService.getAllProductsByType("people");
        model.addAttribute("tails", tails);
        return "clientsPages/peoplesPhotos";
    }

    @RequestMapping("/aboutMe")
    public String aboutMe(Model model) {
//        List<String> aboutMeLines = textReader.infoTextReader();
//        model.addAttribute("aboutMeLines", aboutMeLines);
        return "clientsPages/aboutMeForClients";
    }

    @RequestMapping("/impressum")
    public String getImpressum(Model model) {
        List<String> impressum = textReader.impressumTextReader();
        model.addAttribute("impressumLines", impressum);
        return "clientsPages/impressum";
    }
    @RequestMapping("/myGallery")
    public String getAllTails(Model model) {
        List<Tail> tailsPeople = tailService.getAllProductsByType("people");
        model.addAttribute("tailsPeople", tailsPeople);
        List<Tail> tailsFood = tailService.getAllProductsByType("food");
        model.addAttribute("tailsFood", tailsFood);

        return "clientsPages/myGallery";
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        List<String> contacts = textReader.contactsTextReader();
        model.addAttribute("contacts", contacts);
        return "clientsPages/contacts";
    }
@RequestMapping("/datenschutz")
    public String datenschutz(){
        return "clientsPages/datenschutz";
}
}
