package co.cstad.springdatajpa.api.user;

import co.cstad.springdatajpa.api.userAccount.UserAccount;
import co.cstad.springdatajpa.api.entity.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(unique = true, nullable = false)
    private String uuid;

    private String name;

    private String gender;

    private String email;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_student", columnDefinition = "boolean default false")
    private Boolean isStudent;

    @Column(name = "student_card_no")
    private String studentCardNo;

    @Column(name = "one_signal_id")
    private String oneSignalId;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    private Boolean isVerified;

    @Column(name = "verified_code")
    private String verifiedCode;

    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccounts;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;


}
