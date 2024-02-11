package bit.software.design.consumer.consumers.impl;

import bit.software.design.consumer.consumers.CurrencyConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrinterCurrencyConsumerImpl implements CurrencyConsumer {
    @Override
    public void consumeCurrency(Double currency) {
        log.info("currency: {}", currency);
    }
}
