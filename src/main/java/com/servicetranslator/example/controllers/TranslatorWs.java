package com.servicetranslator.example.controllers;

import com.servicetranslator.example.dto.Response;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
public class TranslatorWs {

    @GET
    @Path("/")
    public Response getTranslatedText(){
        System.out.println("Зашел");
        return new Response();
    }

}
