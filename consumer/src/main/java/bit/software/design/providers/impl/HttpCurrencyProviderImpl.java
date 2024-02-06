package bit.software.design.providers.impl;

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

    @Value("${target_url}")
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
