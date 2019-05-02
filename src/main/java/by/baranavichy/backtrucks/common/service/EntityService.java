package by.baranavichy.backtrucks.common.service;

import java.util.Collection;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface EntityService<T> {

    Collection<T> getAll();

    T save(T to);

    void delete(T to);

}
