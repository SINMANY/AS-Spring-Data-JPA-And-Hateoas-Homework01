package co.cstad.springdatajpa.api.accountType;

import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;
import co.cstad.springdatajpa.api.accountType.web.CreateNewAccountTypeDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface AccountTypeService {

    AccountTypeDto createNewAccountType(CreateNewAccountTypeDto createNewAccountTypeDto);
    CollectionModel<?> findAllAccount();
    EntityModel<?> findAccountTypeById(Integer id);

}
