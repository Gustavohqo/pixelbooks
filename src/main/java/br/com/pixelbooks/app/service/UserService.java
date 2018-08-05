package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.entity.User;
import br.com.pixelbooks.app.exception.CustomException;
import br.com.pixelbooks.app.repository.UserRepository;
import br.com.pixelbooks.app.security.JwtTokenProvider;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username,userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e){
            throw new CustomException("Invalid username/password", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomException("Username is not avaiable", HttpStatus.CONFLICT);
        }
    }
}
