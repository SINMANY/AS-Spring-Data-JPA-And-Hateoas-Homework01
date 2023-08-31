package co.cstad.springdatajpa.api.accountType.web;

import co.cstad.springdatajpa.api.accountType.AccountType;
import co.cstad.springdatajpa.api.accountType.AccountTypeMapStruct;
import co.cstad.springdatajpa.api.accountType.AccountTypeService;
import co.cstad.springdatajpa.api.user.web.UserController;
import co.cstad.springdatajpa.api.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.AccessType;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class AccountTypeAssembler extends RepresentationModelAssemblerSupport<AccountType, EntityModel<AccountTypeDto>> {

    private AccountTypeMapStruct accountTypeMapStruct;

    @Autowired
    public void setAccountTypeMapStruct(AccountTypeMapStruct accountTypeMapStruct) {
        this.accountTypeMapStruct = accountTypeMapStruct;
    }
    public AccountTypeAssembler() {
        super(AccountTypeController.class, (Class<EntityModel<AccountTypeDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<AccountTypeDto> toModel(AccountType entity) {
        AccountTypeDto accountTypeDto = accountTypeMapStruct.mapAccountTypeToAccountTypeDto(entity);
//        Link selfLink =linkTo(methodOn(UserController.class).findUserByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink  =linkTo(methodOn(UserController.class).findUsers()).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(accountTypeDto,collectionLink);
    }
}
