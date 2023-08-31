package co.cstad.springdatajpa.api.assembler;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.account.web.AccountController;
import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.web.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class UserAssembler implements RepresentationModelAssembler<Account, EntityModel<Account>> {
    @Override
    public EntityModel<Account> toModel(Account account) {

        return EntityModel.of(account,
                linkTo(methodOn(AccountController.class).findAllAccounts()).withRel("user"));

    }
}
