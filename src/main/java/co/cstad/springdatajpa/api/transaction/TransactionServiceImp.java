package co.cstad.springdatajpa.api.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{
    private final TransactionRepository transactionRepository;
    @Override
    public Long transactionTransfer(Integer sender, Integer receiver, Long amount, String remark) {
        transactionRepository.transfer(sender,receiver,amount,remark);
        return amount;
    }
}
