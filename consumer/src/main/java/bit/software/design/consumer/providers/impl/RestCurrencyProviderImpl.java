package bit.software.design.consumer.providers.impl;

import bit.software.design.consumer.discovery.DiscoveryServiceProvider;
import bit.software.design.consumer.providers.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestCurrencyProviderImpl implements CurrencyProvider {

    private final String providerServiceName;
    private final DiscoveryServiceProvider discoveryServiceProvider;
    private final RestTemplate restTemplate;


    @Override
    public Double getCurrency() {
        return restTemplate.exchange(
                discoveryServiceProvider.getInstance(providerServiceName).getUri() + "/rest/get",
                HttpMethod.GET,
                null,
                Double.class
        ).getBody();
    }
}
