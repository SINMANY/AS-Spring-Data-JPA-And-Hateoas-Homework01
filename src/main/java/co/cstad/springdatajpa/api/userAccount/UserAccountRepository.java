package co.cstad.springdatajpa.api.userAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    List<UserAccount> findByUserUuid(String uuid);
    Optional<UserAccount> findByUserUuidAndAccountUuid(String userUuid, String accountUuid);

}
