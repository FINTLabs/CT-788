package no.fintlabs;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestUtil {
    private final WebClient webClient;

    public RestUtil(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> Mono<T> get(Class<T> clazz, String uri) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(clazz)
                .log();
    }

    public boolean exists(String endpoint) {
        try {
            Mono<Void> responseMono = webClient.get().uri(endpoint)
                    .retrieve().bodyToMono(Void.class);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}