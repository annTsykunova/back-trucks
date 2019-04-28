package by.baranavichy.backtrucks.importing.model;

import java.util.Optional;

/**
 * Created by Vanya on 28.04.2019.
 */
public enum Action {

    UPDATE, DELETE;

    public static Optional<Action> findByValueIgnoreCase(String value) {
        try {
            return Optional.of(Action.valueOf(value.toUpperCase()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

}
