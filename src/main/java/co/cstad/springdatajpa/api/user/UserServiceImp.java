package co.cstad.springdatajpa.api.user;

import co.cstad.springdatajpa.api.account.Account;
import co.cstad.springdatajpa.api.user.web.CreateUserDto;
import co.cstad.springdatajpa.api.user.web.UpdateUserDto;
import co.cstad.springdatajpa.api.user.web.UserAssembler;
import co.cstad.springdatajpa.api.user.web.UserDto;
import co.cstad.springdatajpa.api.userAccount.UserAccount;
import co.cstad.springdatajpa.api.userAccount.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserMapStruct userMapStruct;
    private final UserAssembler userAssembler;
    private final UserAccountRepository userAccountRepository;


    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
        User user = userMapStruct.mapUserDtoToUser(createUserDto);
        user.setUuid(UUID.randomUUID().toString());
        User userSave = userRepository.save(user);
        return userMapStruct.mapUserToUserDto(userSave);
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<User> users = userRepository.findAllByIsDeletedIsFalse();
        return userAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userAssembler.toModel(user);
    }

    @Override
    public User updatedUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        User user =  userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updateUserDto,user,uuid);

        return userRepository.save(user);

    }

    @Override
    public void removeUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public User disableUserByUuid(Boolean status, String uuid) {
        User user =  userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setIsDeleted(true);
        BeanUtils.copyProperties(user,uuid);
        return userRepository.save(user);
    }

    @Override
    public List<Account> findUserAccountByUuid(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserUuid(uuid);
        List<Account> accounts = userAccounts.stream().map(UserAccount::getAccount).toList();
        return accounts;
    }

    @Override
    public Account findUserAccountByUuidAndAccountByUuid(String userUuid, String accountUuid) {
        User user = userRepository.findByUuid(userUuid).orElseThrow(()-> new EntityNotFoundException("User is not found!"));
        Optional<UserAccount> userAccount = userAccountRepository.findByUserUuidAndAccountUuid(userUuid, accountUuid);
        if (userAccount.isPresent()){
            return userAccount.get().getAccount();
        }else {
            throw new EntityNotFoundException("Account is not found!");
        }
    }
}
