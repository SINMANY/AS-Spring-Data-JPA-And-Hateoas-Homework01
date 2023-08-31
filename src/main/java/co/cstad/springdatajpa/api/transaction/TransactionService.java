package co.cstad.springdatajpa.api.transaction;

public interface TransactionService {
   Long transactionTransfer(Integer sender, Integer receiver, Long amount,String remark);
}
