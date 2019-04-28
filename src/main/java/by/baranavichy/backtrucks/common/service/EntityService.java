package by.baranavichy.backtrucks.common.service;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface EntityService<T> {

    T save(T to);

    void delete(T to);

}
