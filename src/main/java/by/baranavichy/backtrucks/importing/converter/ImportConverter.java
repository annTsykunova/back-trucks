package by.baranavichy.backtrucks.importing.converter;

/**
 * Created by Vanya on 27.04.2019.
 */
public interface ImportConverter<T, I> {

    T toTo(I importTo);

}
