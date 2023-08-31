package co.cstad.springdatajpa.api.user;

import co.cstad.springdatajpa.api.user.web.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUuid(String uuid);
    List<User> findAllByIsDeletedIsFalse();

}
