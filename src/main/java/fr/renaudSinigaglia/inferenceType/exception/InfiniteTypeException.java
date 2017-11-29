package fr.renaudSinigaglia.inferenceType.exception;

import fr.renaudSinigaglia.inferenceType.unification.Unifiable;

/**
 * Created by ssinigag on 29/11/17.
 */
public class InfiniteTypeException extends RuntimeException {

    public InfiniteTypeException(Unifiable t1, Unifiable t2) {
        super("Impossible to unify" + t1 + " and " + t2);
    }
}
