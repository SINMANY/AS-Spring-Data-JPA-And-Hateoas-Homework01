package co.cstad.springdatajpa.api.transaction;

import co.cstad.springdatajpa.api.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(unique = true, nullable = false)
    private String uuid;

    private BigDecimal amount;

    @Column(name = "is_payment")
    private Boolean isPayment;

    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiverActId;

    @ManyToOne
    @JoinColumn(name = "sender_act_id")
    private Account senderActId;

    @Column(name = "transaction_at")
    private LocalDateTime transactionAt;

    private String remark;

    @Column(name = "student_card_no")
    private String studentCardNo;
}
