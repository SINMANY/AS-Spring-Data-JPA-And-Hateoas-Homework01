package co.cstad.springdatajpa.api.user.web;

import co.cstad.springdatajpa.api.user.User;
import co.cstad.springdatajpa.api.user.UserMapStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Configuration
@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {

    private UserMapStruct userMapStruct;

    @Autowired
    public void setUserMapStruct(UserMapStruct userMapStruct) {
        this.userMapStruct = userMapStruct;
    }

    //    @SuppressWarnings("unchecked")
    public UserAssembler() {
        super(UserController.class, (Class<EntityModel<UserDto>>) (Class<?>) EntityModel.class);    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapStruct.mapUserToUserDto(entity);
        Link selfLink =linkTo(methodOn(UserController.class).findUserByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink  =linkTo(methodOn(UserController.class).findUsers()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(userDto,selfLink,collectionLink);
    }
}
