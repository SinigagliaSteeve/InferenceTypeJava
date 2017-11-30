package fr.renaudSinigaglia.inferenceType.inference;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.substitution.Substituable;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.exception.UnboundVariableException;
import fr.renaudSinigaglia.inferenceType.type.Scheme;
import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Env implements Substituable<Env>{
    private HashMap<Var, Scheme> env;

    public Env() {
        this.env = new HashMap<Var, Scheme>();
    }

    public Env(HashMap<Var, Scheme> newMap) {
        this.env = newMap;
    }

    public Scheme lookup(Var variable) {
        Scheme scheme = env.get(variable);
        if (scheme == null) {
            throw new UnboundVariableException(variable);
        }
        return scheme;
    }

    @Override
    public Env apply(Substitution substitution) {

        HashMap<Var, Scheme> newMap = new HashMap<>();
        for (Var var : env.keySet()) {
            newMap.put(var, env.get(var).apply(substitution));
        }
        return new Env(newMap);
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
