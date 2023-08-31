package co.cstad.springdatajpa.api.userAccount;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
   @JsonIgnore
    private Account account;

    @ManyToOne
    @JsonIgnore
    private User user;
}
