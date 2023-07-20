package no.fintlabs;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.utdanning.ot.OTUngdomResources;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class TextClient {
    public String endpoint = "utdanning/ot/otungdom";
    private final RestUtil restUtil;

    public TextClient(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @PostConstruct
    private void fetchData() {
        if (restUtil.exists(endpoint)) {
            restUtil.get(OTUngdomResources.class, endpoint)
                    .doOnNext(l -> log.info(String.valueOf(l)))
                    .doOnError(e -> log.error("Something went wrong: "))
                    .subscribe();
        }
        else{log.error("This endpoint dose not exist");
        }
    }
}