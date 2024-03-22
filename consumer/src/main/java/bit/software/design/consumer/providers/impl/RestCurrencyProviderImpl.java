package bit.software.design.consumer.providers.impl;

import bit.software.design.consumer.providers.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestCurrencyProviderImpl implements CurrencyProvider {

    private final String targetUrl;
    private final RestTemplate restTemplate;


    @Override
    public Double getCurrency() {
        return restTemplate.exchange(
                targetUrl + "/get",
                HttpMethod.GET,
                null,
                Double.class
        ).getBody();
    }
}
