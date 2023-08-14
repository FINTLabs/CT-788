package no.fintlabs;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kodeverk.Kommune;
import no.fint.model.okonomi.faktura.Fakturautsteder;
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
        restUtil.get(Fakturautsteder.class, "/okonomi/faktura/fakturautsteder")
                .doOnNext(l -> log.info(String.valueOf(l)))
                .doOnError(throwable -> restUtil.handleErrorResponse(throwable))
                .subscribe();
    }

}