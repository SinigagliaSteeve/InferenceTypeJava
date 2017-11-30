package fr.renaudSinigaglia.inferenceType.exception;

import fr.renaudSinigaglia.inferenceType.base.Var;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class UnboundVariableException extends RuntimeException {

    public UnboundVariableException(Var variable) {
        super("Unbound variable " + variable);
    }
}
