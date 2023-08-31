package co.cstad.springdatajpa.api.account.web;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.account.AccountMapStruct;
import co.cstad.springdatajpa.api.user.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>>  {


    private AccountMapStruct accountMapStruct;

    public AccountAssembler() {
        super(AccountController.class, (Class<EntityModel<AccountDto>>) (Class<?>) EntityModel.class);
    }

    @Autowired
    public void setAccountMapStruct(AccountMapStruct accountMapStruct) {
        this.accountMapStruct = accountMapStruct;
    }


    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapStruct.mapAccountToAccountDto(entity);
        Link selfLink =linkTo(methodOn(AccountController.class).findAccountByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink  =linkTo(methodOn(AccountController.class).findAllAccounts()).withRel("Find-all-users");

        return EntityModel.of(accountDto,selfLink,collectionLink);
    }
}
