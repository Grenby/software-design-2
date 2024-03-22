package bit.software.design.provider.providers.impl;

import bit.software.design.provider.providers.CurrentCurrencyProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CurrentCurrencyProviderImpl implements CurrentCurrencyProvider {
    @Override
    public Double getCurrentCurrency() {
        return new Random().nextDouble();
    }
}
