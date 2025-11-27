package com.ayush.School.Service;

import com.ayush.School.Constants.EazySchoolConstants;
import com.ayush.School.Controller.ContactController;
import com.ayush.School.Model.Contact;
import com.ayush.School.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ContactService {
    private static Logger log=  LoggerFactory.getLogger(ContactService.class);
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact){
        boolean  isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = this.contactRepository.save(contact);
        if(savedContact != null && savedContact.getContactId() > 1){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> getOpenStatus(){
        List<Contact> openStatusContact = this.contactRepository.findByStatus(EazySchoolConstants.OPEN);

        return openStatusContact;
    }
}
