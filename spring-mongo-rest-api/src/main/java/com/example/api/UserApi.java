package com.example.api;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class UserApi {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Konuralp");
        user.setSurname("Erturk");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(User user)
    {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        return  ResponseEntity.ok(userRepository.findAll());
    }
}
