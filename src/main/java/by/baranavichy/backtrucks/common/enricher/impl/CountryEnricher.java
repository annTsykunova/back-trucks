package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.enricher.ToEnricher;
import by.baranavichy.backtrucks.common.model.to.CountryTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class CountryEnricher extends ToEnricher<CountryTO> {

    @Override
    protected CountryTO enrichTo(CountryTO toToEnrich) {
        return toToEnrich;
    }
}
