package bit.software.design.controllers.impl;

import bit.software.design.controllers.CurrencyController;
import bit.software.design.provider.CurrencyProvider;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CurrencyControllerImpl implements CurrencyController {

    private final CurrencyProvider currencyProvider;

    private final DiscoveryClient client;

    @Override
    @GetMapping("/get")
    public Double getCurrentCurrency() {
        return currencyProvider.getCurrentCurrency();
    }

    @GetMapping("/service")
    public String getServices() {
        val list =  client.getInstances("currency-provider");
        list.forEach(System.out::println);
        if (list.size()>0){
            val c = list.get(0);
            System.out.println(c.getUri().toString());
        }
        return client.getServices().stream().map(Objects::toString).reduce("", (s1, s2)->s1+s2);
    }




}
