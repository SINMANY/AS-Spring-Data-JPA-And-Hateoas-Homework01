package co.cstad.springdatajpa.api.init;

import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.UserRepository;
import co.cstad.springdatajpa.api.userAccount.UserAccount;
import co.cstad.springdatajpa.api.userAccount.UserAccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserAccountInitialization {
    private final UserAccountRepository userAccountRepository;
    @PostConstruct
    void init() {
        System.out.println("Start Initialize data");

        UserAccount userAccount = UserAccount.builder()
                .isDisabled(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        userAccountRepository.saveAll(List.of(userAccount));
    }
}
