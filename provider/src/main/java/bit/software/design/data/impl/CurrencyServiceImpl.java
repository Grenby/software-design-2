package bit.software.design.data.impl;

import bit.software.design.data.CurrencyService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public Double getCurrentCurrency() {
        return new Random().nextDouble();
    }
}
