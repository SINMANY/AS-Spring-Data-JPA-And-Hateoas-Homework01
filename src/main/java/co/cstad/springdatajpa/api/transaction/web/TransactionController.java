package co.cstad.springdatajpa.api.transaction.web;

import co.cstad.springdatajpa.api.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/transfer/")
    public ResponseEntity<?> transferFunds(
            @RequestParam( "sender") Integer sender,
            @RequestParam("receiver") Integer receiver,
            @RequestParam("amount") Long amount,
            @RequestParam("remark")  String remark
    ) {

        transactionService.transactionTransfer(sender, receiver, amount, remark);
        return ResponseEntity.ok().build();
    }
}
