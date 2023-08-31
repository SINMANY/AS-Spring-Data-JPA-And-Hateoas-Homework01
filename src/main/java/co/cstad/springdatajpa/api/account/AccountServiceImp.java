package co.cstad.springdatajpa.api.account;

import co.cstad.springdatajpa.api.account.web.*;
import co.cstad.springdatajpa.api.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements  AccountService{

    private final AccountMapStruct accountMapStruct;
    private final AccountRepository accountRepository;
    private final AccountAssembler accountAssembler;


    @Override
    public AccountDto createNewAccount(CreateAccountDto createAccountDto) {
        Account account = accountMapStruct.mapAccountDtoToAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        Account accountSave = accountRepository.save(account);
        return accountMapStruct.mapAccountToAccountDto(accountSave);
    }

    @Override
    public EntityModel<?> findByUuid(String uuid) {
        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountAssembler.toModel(account);
    }

    @Override
    public Account renameAccountByUuid(String uuid, RenameAccountDto renameAccountDto) {
        Account account =  accountRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(renameAccountDto,account,uuid);
        return accountRepository.save(account);
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<Account> accounts = accountRepository.findAll();
        return accountAssembler.toCollectionModel(accounts);
    }

    @Override
    public Account closeAccountByUuid(String uuid, Boolean status) {
        Account account =  accountRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        account.setIsClosed(true);
        BeanUtils.copyProperties(account,uuid);
        return accountRepository.save(account);
    }

    @Override
    public Account changeTransferLimitByUuid(String uuid, ChangeTransactionDto changeTransactionDto) {
        Account account =  accountRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(changeTransactionDto,account,uuid);
        return accountRepository.save(account);
    }
}
