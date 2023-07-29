package com.obamax.contact.dto;

import lombok.Data;

@Data
public class ContactDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;
}
