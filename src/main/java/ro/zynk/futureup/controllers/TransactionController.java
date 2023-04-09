package ro.zynk.futureup.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.responses.BaseResponse;

import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.TransactionService;


@RestController
@RequestMapping(value = "/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping(value = "")
    public ResponseEntity<BaseResponse> getAllTransactions() {
        try {
            return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/totalPriceGreaterThan/{amountOfUsd}")
    public ResponseEntity<BaseResponse> filterTransactions(@PathVariable("amountOfUsd") Double amountOfUsd)
    {
        try {
            return new ResponseEntity<>(transactionService.filterTransactionsService(amountOfUsd), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
