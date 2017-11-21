package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Scheme extends Substituable<Scheme>{
    private List<TypeVariable> variables;
    private Type type;

    private Scheme(List<TypeVariable> variables, Type type) {
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
        return null;
    }

    @Override
    public Scheme apply(Substituable subst) {
        return null; //todo
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(type.ftv());
        set.removeAll(variables);
        return set;
    }
}
