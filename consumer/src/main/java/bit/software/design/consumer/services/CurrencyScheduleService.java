package bit.software.design.consumer.services;


import bit.software.design.consumer.consumers.CurrencyConsumer;
import bit.software.design.consumer.providers.CurrencyProvider;
import bit.software.design.consumer.providers.impl.JsonRpcCurrencyProviderImpl;
import bit.software.design.consumer.providers.impl.RestCurrencyProviderImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyScheduleService {

    private final CurrencyConsumer currencyConsumer;
    private final JsonRpcCurrencyProviderImpl jsonRpcCurrencyProvider;
    private final RestCurrencyProviderImpl restCurrencyProvider;


    @Scheduled(fixedRateString = "${schedule.delay: PT5S}")
    public void schedule(){
        log.info("jsonRpc");
        currencyConsumer.consumeCurrency(jsonRpcCurrencyProvider.getCurrency());
        log.info("rest");
        currencyConsumer.consumeCurrency(restCurrencyProvider.getCurrency());

    }

}
