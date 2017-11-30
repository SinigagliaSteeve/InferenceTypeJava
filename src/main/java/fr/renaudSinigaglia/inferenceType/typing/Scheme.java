package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.substitution.Subst;
import fr.renaudSinigaglia.inferenceType.substitution.Substituable;

import java.util.*;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Scheme implements Substituable<Scheme> {
    private List<TypeVariable> variables;
    private Type type;

    public Scheme(List<TypeVariable> variables, Type type) {
        this.variables = variables;
        this.type = type;
    }

    public static Scheme forAll(Type type, TypeVariable... variables) {
        if (variables.length == 0) {
            return new Scheme(Collections.<TypeVariable>emptyList(), type);
        }

        return new Scheme(Arrays.asList(variables), type);
    }

    public Type getType() {
        return type;
    }

    public Type instantiate(TypeInfer env) {
        List<TypeVariable> freshVariables = new LinkedList<>();
        variables.forEach(v -> freshVariables.add(env.createFreshTypeVariable()));
        Subst subst = new Subst(variables, freshVariables);
        return this.type.apply(subst);
    }

    @Override
    public Scheme apply(Subst subst) {
        List<TypeVariable> newList = new ArrayList<>();
        for (TypeVariable tv : variables) {
            newList.add((TypeVariable) tv.apply(subst));
        }
        Type newType = type.apply(subst);
        return new Scheme(newList, newType);
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(type.ftv());
        set.removeAll(variables);
        return set;
    }
}
