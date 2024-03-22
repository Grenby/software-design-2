package bit.software.design.consumer.discovery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
@Service
@RequiredArgsConstructor
public class DiscoveryServiceProvider {

    private final Map<String, AtomicInteger> counter = new ConcurrentHashMap<>();
    private final DiscoveryClient discoveryClient;

    public ServiceInstance getInstance(String serviceName){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
        if (serviceInstances.isEmpty()){
            throw new IllegalStateException();
        }
        int index = counter.computeIfAbsent(serviceName, s -> new AtomicInteger(0)).incrementAndGet();
        return serviceInstances.get(
                index % serviceInstances.size()
        );
    }

}
