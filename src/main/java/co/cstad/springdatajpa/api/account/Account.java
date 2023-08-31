package co.cstad.springdatajpa.api.account;

import co.cstad.springdatajpa.api.accountType.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    private String pin;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @ManyToOne
    @JoinColumn(name = "account_types")
    private AccountType accountType;


}
