package bit.software.design.provider.controllers;

import org.springframework.web.bind.annotation.RequestParam;

public interface CurrencyController {

    Double getCurrentCurrency( String currencyFrom, String currencyTo);

}
