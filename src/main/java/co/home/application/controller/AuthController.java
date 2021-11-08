package co.home.application.controller;


import co.home.application.dto.jwt.JwtDto;
import co.home.application.dto.user.UserCredentialsDto;
import co.home.application.dto.user.UserDto;
import co.home.bussines.facade.auth.useCase.IAuthServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin("localhost:4200")
public class AuthController {

    @Autowired
    private IAuthServiceFacade service;

    @PostMapping("/register")
    public void register(@RequestBody UserDto user) {
        service.register(user);
    }

    @PostMapping("/login")
    public JwtDto login(@RequestBody UserCredentialsDto user) {
        return service.login(user);
    }
}
