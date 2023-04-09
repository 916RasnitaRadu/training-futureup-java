package ro.zynk.futureup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.requests.CoinExchangeRequest;
import ro.zynk.futureup.controllers.requests.CoinTransactionRequest;
import ro.zynk.futureup.controllers.responses.BaseResponse;
import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.controllers.responses.WalletResponse;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.WalletService;


@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping(value = "")
    public ResponseEntity<BaseResponse> saveWallet(@RequestBody WalletResponse walletResponse) {
        return new ResponseEntity<>(walletService.saveNewWallet(walletResponse), HttpStatus.OK);
    }


    @GetMapping(value = "")
    public ResponseEntity<BaseResponse> getWallets() {
        try {
            return new ResponseEntity<>(walletService.getWallets(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponse> getWalletById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(walletService.getWallet(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

        @GetMapping(value = "/get_total_value_coins/{id}")
    public Double getTotalValueOfCoins(@PathVariable("id") Long id)
    {
        try {
            return this.walletService.getTotalValueOfCoinsService(id);
        }
        catch (NotFoundException e)
        {
            return -1.0;
        }
    }

    @PutMapping(value = "/buy_coin")
    public ResponseEntity<BaseResponse> buyCoin(@RequestBody CoinTransactionRequest buyCoinRequest) {
        try {
            return new ResponseEntity<>(walletService.buyCoin(buyCoinRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/exchange_coin")
    public ResponseEntity<BaseResponse> exchangeCoin(@RequestBody CoinExchangeRequest coinExchangeRequest) {
        try {
            return new ResponseEntity<>(walletService.exchangeCoin(coinExchangeRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all_owned_coins/{walletId}")
    public ResponseEntity<BaseResponse> getAllOwnedCoinsFromWallet(@PathVariable("walletId") Long walletId) {
        try {
            return new ResponseEntity<>(walletService.getAllCoinsFromWallet(walletId), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
