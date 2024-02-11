package bit.software.design.provider.impl;

import bit.software.design.provider.CurrencyProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CurrencyProviderImpl implements CurrencyProvider {

    @Override
    public Double getCurrentCurrency() {
        return new Random().nextDouble();
    }
}
