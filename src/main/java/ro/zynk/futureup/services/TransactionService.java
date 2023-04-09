package ro.zynk.futureup.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.zynk.futureup.controllers.responses.ListTransactionResponse;
import ro.zynk.futureup.controllers.responses.TransactionResponse;
import ro.zynk.futureup.domain.dtos.Transaction;
import ro.zynk.futureup.domain.repositories.TransactionRepository;
import ro.zynk.futureup.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;


    public ListTransactionResponse getAllTransactions() throws NotFoundException
    {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses = new ArrayList<>();

        if (transactions.size() == 0) {
            throw new NotFoundException("The transaction list is empty");
        }

        for (Transaction t : transactions)
        {
            transactionResponses.add(new TransactionResponse(t));
        }

        return new ListTransactionResponse(transactionResponses);
    }

    public ListTransactionResponse filterTransactionsService(Double amountOfUsd)
    {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses = new ArrayList<>();

        if (transactions.size() == 0) {
            throw new NotFoundException("The transaction list is empty");
        }

        for (Transaction t : transactions) {
            if (t.getTotalValue() > amountOfUsd)
            {
                transactionResponses.add(new TransactionResponse(t));
            }
        }
        return new ListTransactionResponse(transactionResponses);
    }

}
