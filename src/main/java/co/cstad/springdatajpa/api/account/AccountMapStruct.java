package co.cstad.springdatajpa.api.account;

import co.cstad.springdatajpa.api.account.web.AccountDto;
import co.cstad.springdatajpa.api.account.web.CreateAccountDto;
import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapStruct {
    Account mapAccountDtoToAccount(CreateAccountDto createAccountDto);
    AccountDto mapAccountToAccountDto(Account account);
}
