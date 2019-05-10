package by.baranavichy.backtrucks.common.enricher;

/**
 * Created by Vanya on 10.05.2019.
 */
public interface EntityEnricher<E> {

    E enrich(E entityToEnrich);

}
