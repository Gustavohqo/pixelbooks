package br.com.pixelbooks.app.controller;

import br.com.pixelbooks.app.entity.User;
import br.com.pixelbooks.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/signup", method = RequestMethod.POST, headers="Content-Type=application/json")
    public String signup(@RequestBody User user){
        return userService.signup(user);
    }

    @RequestMapping(value="/signin", method = RequestMethod.POST,  headers="Content-Type=application/json")
    public String signin(@RequestBody User user) { return userService.signin(user); }
}
