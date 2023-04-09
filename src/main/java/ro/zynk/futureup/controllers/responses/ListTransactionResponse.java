package ro.zynk.futureup.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;

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
