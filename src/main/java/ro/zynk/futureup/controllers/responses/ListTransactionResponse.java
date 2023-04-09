package ro.zynk.futureup.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;


// created a new response class for the list of transactions
@NoArgsConstructor
@Getter
@Setter
public class ListTransactionResponse extends BaseResponse {
    private List<TransactionResponse> transactionResponseList;

    public ListTransactionResponse(List<TransactionResponse> transactionList)
    {
        this.transactionResponseList = transactionList;
    }
}
