package co.cstad.springdatajpa.api.accountType;

import co.cstad.springdatajpa.api.accountType.web.AccountTypeAssembler;
import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;
import co.cstad.springdatajpa.api.accountType.web.CreateNewAccountTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeAssembler accountTypeAssembler;
    private final AccountTypeMapStruct accountTypeMapStruct;

    @Override
    public AccountTypeDto createNewAccountType(CreateNewAccountTypeDto createNewAccountTypeDto) {
        AccountType accountType = accountTypeMapStruct.mapAccountTypeDtoToAccountType(createNewAccountTypeDto);
        AccountType accountTypeSave = accountTypeRepository.save(accountType);
        return accountTypeMapStruct.mapAccountTypeToAccountTypeDto(accountTypeSave);
    }

    @Override
    public CollectionModel<?> findAllAccount() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return accountTypeAssembler.toCollectionModel(accountTypes);
    }

    @Override
    public EntityModel<?> findAccountTypeById(Integer id) {
        AccountType accountType = accountTypeRepository.findById(id).orElseThrow();
        return accountTypeAssembler.toModel(accountType);
    }


}
