package co.cstad.springdatajpa.api.account.web;

import java.math.BigDecimal;

public record ChangeTransactionDto(BigDecimal transferLimit) {
}
