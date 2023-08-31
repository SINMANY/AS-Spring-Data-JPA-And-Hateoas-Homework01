package co.cstad.springdatajpa.api.account.web;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.account.AccountService;
import co.cstad.springdatajpa.api.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public BaseRest<?> createNewUser(@RequestBody CreateAccountDto createAccountDto){
        AccountDto accountDto = accountService.createNewAccount(createAccountDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account created successfully!")
                .timestamp(LocalDateTime.now())
                .data(accountDto)
                .build();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUserByUuid(@PathVariable String uuid){
        return accountService.findByUuid(uuid);
    }

    @PutMapping("/{uuid}/rename")
    public BaseRest<?> updateUserByUuid(@RequestBody RenameAccountDto renameAccountDto, @PathVariable String uuid){
        Account account = accountService.renameAccountByUuid(uuid, renameAccountDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account have rename successfully!")
                .timestamp(LocalDateTime.now())
                .data(account)
                .build();
    }

    @GetMapping
    public CollectionModel<?> findUsers() {
        return accountService.findAllUser();
    }

    @PutMapping("/{uuid}/close")
    public BaseRest<?> disableUser(@PathVariable String uuid, Boolean status){
        Account isClosed = accountService.closeAccountByUuid(uuid, status);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account have closed successfully!")
                .timestamp(LocalDateTime.now())
                .data(isClosed)
                .build();
    }
    @PutMapping("/{uuid}/limit-transfer")
    public BaseRest<?> updateUserByUuid(@RequestBody ChangeTransactionDto changeTransactionDto, @PathVariable String uuid){
        Account account = accountService.changeTransferLimitByUuid(uuid, changeTransactionDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Transfer limit have been changed successfully!")
                .timestamp(LocalDateTime.now())
                .data(account)
                .build();
    }

}
