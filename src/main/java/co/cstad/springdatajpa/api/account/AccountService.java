package co.cstad.springdatajpa.api.account;

import co.cstad.springdatajpa.api.account.web.AccountDto;
import co.cstad.springdatajpa.api.account.web.ChangeTransactionDto;
import co.cstad.springdatajpa.api.account.web.CreateAccountDto;
import co.cstad.springdatajpa.api.account.web.RenameAccountDto;
import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    AccountDto createNewAccount(CreateAccountDto createAccountDto);
    EntityModel<?> findByUuid(String uuid);
    Account renameAccountByUuid(String uuid, RenameAccountDto renameAccountDto);
    CollectionModel<?> findAllUser();
    Account closeAccountByUuid(String uuid, Boolean status);
    Account changeTransferLimitByUuid(String uuid, ChangeTransactionDto changeTransactionDto);
}
