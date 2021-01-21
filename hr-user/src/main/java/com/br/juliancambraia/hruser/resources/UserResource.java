package com.br.juliancambraia.hruser.resources;

import com.br.juliancambraia.hruser.entities.User;
import com.br.juliancambraia.hruser.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByUserEmail(@RequestParam String email) {
        return ResponseEntity.ok(repository.findByEmail(email));
    }
}
