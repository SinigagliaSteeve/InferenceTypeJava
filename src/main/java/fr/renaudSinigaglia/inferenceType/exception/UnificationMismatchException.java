package fr.renaudSinigaglia.inferenceType.exception;

import fr.renaudSinigaglia.inferenceType.typing.TypeList;

/**
 * Created by ssinigag on 29/11/17.
 */
public class UnificationMismatchException extends RuntimeException {

    public UnificationMismatchException(TypeList t1, TypeList t2) {
        super("Unification mismatch between " + t1 + " " + t2);
    }
}
