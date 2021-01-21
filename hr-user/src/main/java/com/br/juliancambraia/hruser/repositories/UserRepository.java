package com.br.juliancambraia.hruser.repositories;

import com.br.juliancambraia.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
