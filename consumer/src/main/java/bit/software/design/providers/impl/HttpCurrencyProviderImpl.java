package bit.software.design.providers.impl;

import bit.software.design.discovery.DiscoveryServiceProvider;
import bit.software.design.providers.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class HttpCurrencyProviderImpl implements CurrencyProvider {

    @Value("${target_service}")
    private final String targetService;
    private final RestTemplate restTemplate;
    private final DiscoveryServiceProvider serviceProvider;


    @Override
    public Double getCurrency() {
        return restTemplate.exchange(
                serviceProvider.getInstance(targetService).getUri().toString() + "/get",
                HttpMethod.GET,
                null,
                Double.class
        ).getBody();
    }
}
