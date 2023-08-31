package co.cstad.springdatajpa.api.transaction;

import co.cstad.springdatajpa.api.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
