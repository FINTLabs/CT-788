package no.fintlabs;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kodeverk.Kommune;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;


@Slf4j
@Controller
public class TextClient {
    private final RestUtil restUtil;

    public TextClient(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @PostConstruct
    private void fetchData() {
        restUtil.get(Kommune.class, "/felles/kodeverk/kommune")
                .doOnNext(l -> log.info(String.valueOf(l)))
                .doOnError(throwable -> restUtil.handleErrorResponse(throwable))
                .subscribe();
    }

}