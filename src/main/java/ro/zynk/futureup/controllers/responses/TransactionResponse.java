package ro.zynk.futureup.controllers.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponse extends BaseResponse{
    private Long id;

    private Date transactionDate;
    private Long coinId;

    private Float amount;

    private Double totalValue;

    public TransactionResponse(Transaction transaction)
    {
        this.id = transaction.getId();
        this.transactionDate = transaction.getTransactionDate();
        this.coinId = transaction.getCoin().getId();
        this.amount = transaction.getAmount();
        this.totalValue = transaction.getTotalValue();
    }
}
