package no.fintlabs;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.utdanning.larling.LarlingResources;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import javax.annotation.PostConstruct;


@Slf4j
@Service
public class TextClient {
    private final RestUtil restUtil;

    public TextClient(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @PostConstruct
    private void fetchData() {
        restUtil.get(LarlingResources.class, "/utdanning/larling/person")
                .doOnNext(l -> log.info(String.valueOf(l)))
                .subscribe();
    }
}