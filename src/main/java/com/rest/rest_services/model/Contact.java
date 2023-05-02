package com.rest.rest_services.model;

import lombok.Data;

@Data
public class Contact{

    private int contactId;
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;

}
