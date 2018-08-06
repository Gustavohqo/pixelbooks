package br.com.pixelbooks.app.controller;

import br.com.pixelbooks.app.dto.authentication.AuthenticationDTO;
import br.com.pixelbooks.app.dto.user.UserSigninDTO;
import br.com.pixelbooks.app.entity.User;
import br.com.pixelbooks.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/signup", method = RequestMethod.POST, headers="Content-Type=application/json")
    @ResponseBody
    public AuthenticationDTO signup(@RequestBody User user){
        return userService.signup(user);
    }

    @RequestMapping(value="/signin", method = RequestMethod.POST,  headers="Content-Type=application/json")
    @ResponseBody
    public AuthenticationDTO signin(@RequestBody UserSigninDTO user) {
        System.out.println(user);
        AuthenticationDTO token = userService.signin(user);
        System.out.println(token);
        return token; }
}
