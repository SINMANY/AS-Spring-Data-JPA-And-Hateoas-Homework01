package co.cstad.springdatajpa.api.account.web;

import co.cstad.springdatajpa.api.accountType.AccountType;
import co.cstad.springdatajpa.api.accountType.web.AccountTypeDto;

import java.math.BigDecimal;
import java.util.List;

public record AccountDto(String actName,
                         String actNo,
                         String pin,
                         BigDecimal transferLimit,
                         Boolean isClosed,
                        AccountTypeDto accountType) {
}
