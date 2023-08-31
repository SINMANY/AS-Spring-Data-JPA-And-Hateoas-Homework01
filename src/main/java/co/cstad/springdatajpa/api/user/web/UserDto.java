package co.cstad.springdatajpa.api.user.web;

import co.cstad.springdatajpa.api.entity.Role;
import co.cstad.springdatajpa.api.userAccount.UserAccount;


import java.util.List;

public record UserDto(String uuid,
                      String name,
                      String gender,
                      String email,
                      String password,
                      String phoneNumber,
                      String studentCardNo,
                      Boolean isDeleted,
                      List<UserAccount> userAccounts,
                      List<Role> roles) {


}
