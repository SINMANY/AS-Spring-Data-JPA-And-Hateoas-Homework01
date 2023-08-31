package co.cstad.springdatajpa.api.accountType.web;


import co.cstad.springdatajpa.api.accountType.AccountTypeService;
import co.cstad.springdatajpa.api.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {
    private final AccountTypeService accountTypeService;

    @PostMapping
    public BaseRest<?> createNewUser(@RequestBody CreateNewAccountTypeDto createNewAccountTypeDto){
        AccountTypeDto accountTypeDto = accountTypeService.createNewAccountType(createNewAccountTypeDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account created successfully!")
                .timestamp(LocalDateTime.now())
                .data(accountTypeDto)
                .build();
    }
    @GetMapping
    public CollectionModel<?> findUsers() {
        return accountTypeService.findAllAccount();
    }

    @GetMapping("/{id}")
    public EntityModel<?> findUserByUuid(@PathVariable Integer id){
        return accountTypeService.findAccountTypeById(id);
    }


}
