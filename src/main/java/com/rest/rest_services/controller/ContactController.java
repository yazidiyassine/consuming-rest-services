package com.rest.rest_services.controller;

import com.rest.rest_services.model.Contact;
import com.rest.rest_services.model.Response;
import com.rest.rest_services.proxy.ContactProxy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ContactController {

    private final ContactProxy contactProxy;
    private final RestTemplate restTemplate;

    public ContactController(ContactProxy contactProxy, RestTemplate restTemplate) {
        this.contactProxy = contactProxy;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam("status") String status){
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom", "RestTemplate");
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact, headers);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(uri, HttpMethod.POST,
                httpEntity, Response.class);
        return responseEntity;

    }
}
