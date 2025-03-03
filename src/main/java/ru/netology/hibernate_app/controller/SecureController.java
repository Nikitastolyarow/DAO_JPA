package ru.netology.hibernate_app.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("/secure")
public class SecureController
{
    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String  readAccess(){
        return "Отлично, доступно для чтения";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/write")
    public String  writeAccess(){
        return "Отлично, доступно для записи";
    }

    @GetMapping("/write-on-delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_READ')")
    public String  writeOrDeleteAccess(){
        return "Отлично, доступно для записи и для чтения";
    }

    @GetMapping("/user")
    @PreAuthorize("#username == authentication.name")
    public String userAccess(@RequestParam String username , Principal principal){
        return "Этому пользователю разрешен доступ";
    }
}
