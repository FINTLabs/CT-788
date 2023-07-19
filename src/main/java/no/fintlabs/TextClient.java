package no.fintlabs;


import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.utdanning.utdanningsprogram.SkoleResources;
import org.springframework.stereotype.Service;

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
        restUtil.get(SkoleResources.class, "https://beta.felleskomponent.no/utdanning/utdanningsprogram")
                .doOnNext(l -> log.info(String.valueOf(l)))
                .subscribe();
    }
}