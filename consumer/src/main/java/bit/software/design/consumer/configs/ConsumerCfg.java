package bit.software.design.consumer.configs;


import bit.software.design.consumer.providers.impl.JsonRpcCurrencyProviderImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class ConsumerCfg {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public JsonRpcCurrencyProviderImpl jsonRpcCurrencyProvider(
            @Value("${target_url}") String url,
            RestTemplate template,
            ObjectMapper objectMapper
    ){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(
                """
                        {
                        "jsonrpc": "2.0",
                        "method": "get",
                        "params": {},
                        "id": 555
                        }
                        """,
                headers
        );
        return new JsonRpcCurrencyProviderImpl(
                url,
                template,
                requestEntity,
                objectMapper
        );
    }

}
