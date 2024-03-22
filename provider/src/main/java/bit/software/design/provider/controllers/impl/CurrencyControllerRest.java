package bit.software.design.provider.controllers.impl;

import bit.software.design.provider.controllers.CurrencyController;
import bit.software.design.provider.providers.CurrentCurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class CurrencyControllerRest implements CurrencyController {

    private final CurrentCurrencyProvider currencyProvider;;

    @Override
    @GetMapping("/get")
    public Double getCurrentCurrency(@RequestParam(value = "from", defaultValue = "rub") String currencyFrom,
                                     @RequestParam(value = "to", defaultValue = "usd") String currencyTo ) {
        return currencyProvider.getCurrentCurrency(currencyFrom,currencyTo);
    }
}
