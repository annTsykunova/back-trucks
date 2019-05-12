package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.enricher.EntityFetcher;
import by.baranavichy.backtrucks.persistence.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class CountryFetcher extends EntityFetcher<Country> {

}
