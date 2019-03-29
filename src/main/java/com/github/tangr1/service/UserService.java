package com.github.tangr1.service;

import com.github.tangr1.model.User;
import com.github.tangr1.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void setup() {
        User demo = User.builder()
                .username("demo")
                .password("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC")
                .role("ROLE_DOCTOR")
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        User admin = User.builder()
                .username("admin")
                .password("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC")
                .role("ROLE_ADMIN")
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        userRepository.save(demo);
        userRepository.save(admin);
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
