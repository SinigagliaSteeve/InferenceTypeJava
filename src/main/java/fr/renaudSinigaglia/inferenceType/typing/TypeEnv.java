package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.exception.UnboundVariable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class TypeEnv extends Substituable<TypeEnv>{
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

    @Override
    public TypeEnv apply(Substituable subst) {
        return null;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        for (Scheme scheme : env.values()) {
            set.addAll(scheme.ftv());
        }
        return set;
    }
}
