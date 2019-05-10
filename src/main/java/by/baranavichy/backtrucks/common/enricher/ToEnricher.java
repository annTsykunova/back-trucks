package by.baranavichy.backtrucks.common.enricher;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Slf4j
public abstract class ToEnricher<T> {

    @Transactional(Transactional.TxType.MANDATORY)
    public T enrich(T toToEnrich) {
        log.debug(String.format("Enriching TO %s", toToEnrich));
        return enrichTo(toToEnrich);
    }

    protected abstract T enrichTo(T toToEnrich);

}
