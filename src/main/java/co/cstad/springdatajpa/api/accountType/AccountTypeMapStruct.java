package co.cstad.springdatajpa.api.accountType;

import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;
import co.cstad.springdatajpa.api.accountType.web.CreateNewAccountTypeDto;
import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.web.CreateUserDto;
import co.cstad.springdatajpa.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTypeMapStruct {

    AccountType mapAccountTypeDtoToAccountType(CreateNewAccountTypeDto createNewAccountTypeDto);
    AccountTypeDto mapAccountTypeToAccountTypeDto(AccountType accountType);
}
