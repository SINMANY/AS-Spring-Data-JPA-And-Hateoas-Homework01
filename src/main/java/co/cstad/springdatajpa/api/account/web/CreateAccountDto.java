package co.cstad.springdatajpa.api.account.web;

import java.math.BigDecimal;

public record CreateAccountDto(String actName,
                               String actNo,
                               String pin,
                               Boolean isClosed,
                               BigDecimal transferLimit) {
}
