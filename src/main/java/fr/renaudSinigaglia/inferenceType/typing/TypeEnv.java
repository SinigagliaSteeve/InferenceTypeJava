package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.exception.UnboundVariable;

import java.util.HashMap;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class TypeEnv {
    private HashMap<Var, Scheme> env;

    public TypeEnv() {
        this.env = new HashMap<Var, Scheme>();
    }

    public Scheme lookup(Var variable) {
        Scheme scheme = env.get(variable);
        if (scheme == null) {
            throw new UnboundVariable(variable);
        }
        return scheme;
    }
}
