package bit.software.design.provider.controllers.impl;

import bit.software.design.provider.controllers.CurrencyController;
import bit.software.design.provider.providers.CurrentCurrencyProvider;
import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@JsonRpcService("/provider")
@AutoJsonRpcServiceImpl
public class CurrencyControllerImpl implements CurrencyController {

    private final CurrentCurrencyProvider currencyProvider;

    @Override
    @JsonRpcMethod("get")
    public Double getCurrentCurrency() {
        return currencyProvider.getCurrentCurrency();
    }

}
