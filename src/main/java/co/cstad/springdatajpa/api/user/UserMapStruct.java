package co.cstad.springdatajpa.api.user;

import co.cstad.springdatajpa.api.user.web.CreateUserDto;
import co.cstad.springdatajpa.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User mapUserDtoToUser(CreateUserDto createUserDto);
    UserDto mapUserToUserDto(User user);
}
