package com.obamax.contact.service;

import com.obamax.contact.dto.ContactDTO;
import com.obamax.contact.exception.ResourceNotFoundException;
import com.obamax.contact.model.Contact;
import com.obamax.contact.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact createContact(ContactDTO request) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(request, contact);
        return contactRepository.save(contact);
    }

    public Contact getContact(Integer id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact Not Found :: " + id));
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public void deleteContactById(Integer id) {
        Contact contact = this.getContact(id);
        contactRepository.delete(contact);
    }

    public Contact updateContact(Integer id, ContactDTO request) {
        Contact contact = this.getContact(id);

        BeanUtils.copyProperties(request, contact);

        return contactRepository.save(contact);
    }
}
