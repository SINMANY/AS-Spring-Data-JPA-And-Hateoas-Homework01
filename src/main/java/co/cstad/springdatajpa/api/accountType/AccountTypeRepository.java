package co.cstad.springdatajpa.api.accountType;

import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType, EntityModel<AccountTypeDto>> {

    Optional<AccountType> findById(Integer id);
}
