package com.example.registeruserlogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class Controller {


    @Autowired
    private Repository2 rep;

    @Autowired
    private HttpSession session;



    //Step 1
    @GetMapping("/login")
    public boolean login(Bruker bruker, HttpServletResponse response) throws IOException {
        if(rep.login(bruker)) {
            session.setAttribute("LoggedIn", bruker);
            return true;
        }
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil brukernavn eller passord");
        return false;
    }



    //Step 2
    @PostMapping("/opprettBruker")
    public boolean opprett(Bruker b, HttpServletResponse response) throws IOException {
        if(!rep.opprett(b)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Brukernavn finnes allerede. Velg et annet");
            return false;
        }
        return true;
    }
}
