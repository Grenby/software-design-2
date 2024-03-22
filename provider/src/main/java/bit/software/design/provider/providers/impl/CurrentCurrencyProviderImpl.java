package bit.software.design.provider.providers.impl;

import bit.software.design.provider.providers.CurrentCurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class CurrentCurrencyProviderImpl implements CurrentCurrencyProvider {

    @Value("${currency}")
    private final double currency;

    @Override
    public double getCurrentCurrency(String currencyFrom, String currencyTo) {
        return new Random().nextDouble() * currency;
    }
}
