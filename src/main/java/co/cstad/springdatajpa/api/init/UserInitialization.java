package co.cstad.springdatajpa.api.init;


import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserInitialization {
    private final UserRepository userRepository;
    @PostConstruct
    void init() {
        System.out.println("Start Initialize data");

        User student = User.builder()
                .uuid(UUID.randomUUID().toString())
                .name("many")
                .gender("female")
                .email("manysin48@gmail.com")
                .password("2329")
                .phoneNumber("0886610148")
                .studentCardNo("00001")
                .isDeleted(false)
                .build();
        userRepository.saveAll(List.of(student));
    }
}