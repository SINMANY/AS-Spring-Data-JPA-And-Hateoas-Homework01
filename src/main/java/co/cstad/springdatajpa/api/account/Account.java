package co.cstad.springdatajpa.api.account;

import co.cstad.springdatajpa.api.accountType.AccountType;
import co.cstad.springdatajpa.api.userAccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(name = "transfer_limit")
    private BigDecimal transferLimit;

    @Column(name = "act_name")
    private String actName;

    @Column(name = "act_no")
    private String actNo;

    private Double balance;

    private String pin;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @OneToMany(mappedBy = "account")
    private List<UserAccount> userAccounts;

    @ManyToOne
    @JoinColumn(name = "account_types")
    private AccountType accountType;


}
