package fr.renaudSinigaglia.inferenceType.exception;

import fr.renaudSinigaglia.inferenceType.base.Var;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class UnboundVariable extends RuntimeException {

    public UnboundVariable(Var variable) {
        super("Unbound variable " + variable);
    }
}
