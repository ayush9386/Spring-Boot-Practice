package com.ayush.School.Controller;

import com.ayush.School.Model.Contact;
import com.ayush.School.Service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {
    private static Logger log=  LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact" , new Contact());
        return "contact.html";
    }


    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute Contact contact , Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to :" + errors.toString());
            return "contact.html";
        }
        this.contactService.saveMessageDetails(contact);
        return  "redirect:/thankyou";
    }

    @GetMapping(value = "/findopenstatus")
    public String findMsgWithOpenStatus(Model model){
        List<Contact> openStatusContactDetails =  this.contactService.getOpenStatus();
        System.out.println(openStatusContactDetails.size());
        model.addAttribute("contacts" , openStatusContactDetails);
        return "openstatus.html";
    }


//    @RequestMapping(value ="/saveMsg",method = RequestMethod.POST)
//    @PostMapping(value = "/saveMsg" )
//    public ModelAndView saveMessage(@RequestParam String name , @RequestParam String phone,
//                                    @RequestParam String email , @RequestParam String subject , @RequestParam String message){
//        //System.out.println(name + " " + phone + " " + email +" " + subject);
//        log.info("Name :" + name);
//        log.info("phone number :" + phone);
//        log.info("phone number :" + email);
//        log.info("phone number :" + subject);
//        log.info("phone number :" + message);
//        return new ModelAndView("redirect:/thankyou");
}
