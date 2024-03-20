package bit.software.design.provider.impl;

import bit.software.design.provider.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
@RequiredArgsConstructor
public class CurrencyProviderImpl implements CurrencyProvider {

    @Value("${currency}")
    private final int currency;

    @Override
    public Double getCurrentCurrency() {
        return new Random().nextDouble() * currency;
    }
}
