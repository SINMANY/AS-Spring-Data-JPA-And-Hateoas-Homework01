package co.cstad.springdatajpa.api.user.web;

import co.cstad.springdatajpa.api.entity.Role;
import co.cstad.springdatajpa.api.userAccount.UserAccount;

import java.util.List;

public record CreateUserDto(String name,
                            String gender,
                            String email,
                            String password,
                            String phoneNumber,
                            Boolean isDeleted,
                            String studentCardNo,
                            List<UserAccount> userAccounts,
                            List<Role> roles) {
}
