package bit.software.design.services;


import bit.software.design.consumers.CurrencyConsumer;
import bit.software.design.providers.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyScheduleService {

    private final CurrencyConsumer currencyConsumer;
    private final CurrencyProvider currencyProvider;

    @Scheduled(fixedRateString = "${schedule.delay: PT5S}")
    public void schedule(){
        currencyConsumer.consumeCurrency(currencyProvider.getCurrency());
    }

}
