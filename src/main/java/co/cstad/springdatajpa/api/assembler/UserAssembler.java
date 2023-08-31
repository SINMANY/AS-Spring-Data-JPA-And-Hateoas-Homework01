package co.cstad.springdatajpa.api.assembler;

import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.web.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class UserAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return null;

//        return EntityModel.of(user,
//                linkTo(methodOn(UserController.class).findAllUser()).withRel("user"));

    }
}
