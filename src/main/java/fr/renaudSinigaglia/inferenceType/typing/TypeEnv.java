package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;
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

    public TypeEnv(HashMap<Var, Scheme> newMap) {
        this.env = newMap;
    }

    public Scheme lookup(Var variable) {
        Scheme scheme = env.get(variable);
        if (scheme == null) {
            throw new UnboundVariable(variable);
        }
        return scheme;
    }

    @Override
    public TypeEnv apply(Subst subst) {

        HashMap<Var, Scheme> newMap = new HashMap<>();
        for (Var var : env.keySet()) {
            newMap.put(var, env.get(var).apply(subst));
        }
        return new TypeEnv(newMap);
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        for (Scheme scheme : env.values()) {
            set.addAll(scheme.ftv());
        }
        return set;
    }

    public void remove(Var var) {
        env.remove(var);
    }

    public void extend(Var var, Scheme scheme) {
        env.put(var, scheme);
    }
}
