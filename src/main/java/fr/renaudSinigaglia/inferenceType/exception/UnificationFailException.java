package fr.renaudSinigaglia.inferenceType.exception;

import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * Created by ssinigag on 29/11/17.
 */
public class UnificationFailException extends RuntimeException {

    public UnificationFailException(Type t1, Type t2) {
        super("Unification failed between " + t1 + " " + t2);
    }
}
