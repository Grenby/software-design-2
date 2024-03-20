package bit.software.design.controllers.impl;

import bit.software.design.controllers.CurrencyController;
import bit.software.design.provider.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyControllerImpl implements CurrencyController {

    private final CurrencyProvider currencyProvider;

    @Override
    @GetMapping("/get")
    public Double getCurrentCurrency() {
        return currencyProvider.getCurrentCurrency();
    }
}
