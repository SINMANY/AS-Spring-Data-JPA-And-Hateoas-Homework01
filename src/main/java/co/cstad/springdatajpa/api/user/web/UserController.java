package co.cstad.springdatajpa.api.user.web;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.base.BaseRest;
import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
public BaseRest<?> createNewUser(@RequestBody CreateUserDto createUserDto){
        UserDto userDto= userService.createNewUser(createUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User created successfully")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUserByUuid(@PathVariable String uuid){
        return userService.findByUuid(uuid);
    }

    @GetMapping
    public CollectionModel<?> findUsers() {
        return userService.findAllUser();
    }

    @PutMapping("/{uuid}")
    public BaseRest<?> updateUserByUuid(@RequestBody UpdateUserDto updateUserDto,@PathVariable String uuid){
        User user = userService.updatedUserByUuid(uuid, updateUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User created successfully")
                .timestamp(LocalDateTime.now())
                .data(user)
                .build();
    }

    @DeleteMapping("/{uuid}")
    public BaseRest<?> removeUserByUuid(@PathVariable String uuid){
         userService.removeUserByUuid(uuid);
         return BaseRest.builder().status(true)
                 .code(HttpStatus.OK.value())
                 .message("User have been deleted successfully")
                 .timestamp(LocalDateTime.now())
                 .build();
    }

    @PutMapping("/{uuid}/disable")
    public BaseRest<?> disableUser(@PathVariable String uuid, Boolean status){
        User isDisable = userService.disableUserByUuid(status, uuid);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User created successfully")
                .timestamp(LocalDateTime.now())
                .data(isDisable)
                .build();
    }

    @GetMapping("/{uuid}/accounts")
    public BaseRest<?> findUserAccountByUuid(@PathVariable String uuid){
        List<Account> accounts = userService.findUserAccountByUuid(uuid);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Find user account successfully!")
                .timestamp(LocalDateTime.now())
                .data(accounts)
                .build();
    }

    @GetMapping("/{userUuid}/accounts/{accountUuid}")
    public BaseRest<?> findUserByUuidAndAccountByUuid(@PathVariable String userUuid, @PathVariable String accountUuid){
        Account accounts = userService.findUserAccountByUuidAndAccountByUuid(userUuid, accountUuid);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Find user account successfully!")
                .timestamp(LocalDateTime.now())
                .data(accounts)
                .build();
    }

}

