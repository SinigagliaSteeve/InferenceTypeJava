package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;
import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;

import java.util.*;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Scheme extends Substituable<Scheme>{
    private List<TypeVariable> variables;
    private Type type;

    public Scheme(List<TypeVariable> variables, Type type) {
        this.variables = variables;
        this.type = type;
    }

    public static Scheme forAll(Type type, TypeVariable... variables) {
        if (variables.length == 0) { //todo watch if null?
            return new Scheme(Collections.<TypeVariable>emptyList(), type);
        }

        return new Scheme(Arrays.asList(variables), type);
    }

    public List<TypeVariable> getVariables() {
        return variables;
    }

    public Type getType() {
        return type;
    }

    public Type instantiate(TypeInfer env) {
        //todo infer.hs
        List<TypeVariable> freshVariables = new LinkedList<>();
        for (TypeVariable var : variables) {
            freshVariables.add(env.createFreshTypeVariable());
        }
        Subst subst = new Subst(variables, freshVariables);
        return apply(subst).type;
    }

    @Override
    public Scheme apply(Subst subst) {
        List<TypeVariable> newList = new ArrayList<>();
        for (TypeVariable tv : variables) {
            newList.add(tv.apply(subst));
        }
        Type newType = (Type) type.apply(subst);
        return new Scheme(newList, newType); //todo
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(type.ftv());
        set.removeAll(variables);
        return set;
    }
}
