package co.cstad.springdatajpa.api.accountType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;

}
