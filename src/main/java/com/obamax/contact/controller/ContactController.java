package com.obamax.contact.controller;

import com.obamax.contact.dto.ContactDTO;
import com.obamax.contact.model.Contact;
import com.obamax.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        String message = "We are live!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Contact> createContact(@RequestBody ContactDTO request) {
        Contact contact = contactService.createContact(request);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable(name = "id") Integer id) {
        Contact contact = contactService.getContact(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable(name = "id") Integer id, @RequestBody ContactDTO request) {
        Contact contact = contactService.updateContact(id, request);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(name = "id") Integer id) {
        contactService.deleteContactById(id);
        String message = "Contact deleted!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
