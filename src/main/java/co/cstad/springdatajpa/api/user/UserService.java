package co.cstad.springdatajpa.api.user;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.user.web.CreateUserDto;
import co.cstad.springdatajpa.api.user.web.UpdateUserDto;
import co.cstad.springdatajpa.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);

    CollectionModel<?> findAllUser();

    EntityModel<?> findByUuid(String uuid);

    User updatedUserByUuid(String uuid, UpdateUserDto updateUserDto);

    void removeUserByUuid(String uuid);

    User disableUserByUuid(Boolean status, String uuid);

    List<Account> findUserAccountByUuid(String uuid);

    Account findUserAccountByUuidAndAccountByUuid(String userUuid, String accountUuid);

}
