package bit.software.design.consumer.providers.impl;

import bit.software.design.consumer.providers.CurrencyProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class JsonRpcCurrencyProviderImpl implements CurrencyProvider {

    private final String targetUrl;
    private final RestTemplate restTemplate;
    private final HttpEntity<String> requestEntity;
    private final ObjectMapper objectMapper;

    @Override
    public Double getCurrency() {

        String response = restTemplate.exchange(
                targetUrl+"/jsonrpc",
                HttpMethod.POST,
                requestEntity,
                String.class
        ).getBody();

        try {
            Map<String, Object> map = objectMapper.readValue(response, new TypeReference<>() {});
            return (Double) map.get("result");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
