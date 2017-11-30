package fr.renaudSinigaglia.inferenceType.type;

import fr.renaudSinigaglia.inferenceType.inference.Infer;
import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.substitution.Substituable;

import java.util.*;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 *
 * Classe représentant les scheme correspondant à la généralisation d'un type
 */
public class Scheme implements Substituable<Scheme> {
    private List<TypeVariable> variables;
    private Type type;

    public Scheme(List<TypeVariable> variables, Type type) {
        this.variables = variables;
        this.type = type;
    }

    /**
     * Constructeur d'un scheme
     * @param type Le type de base
     * @param variables les variables de type libres
     * @return Un nouveau scheme
     */
    public static Scheme forAll(Type type, TypeVariable... variables) {
        if (variables.length == 0) {
            return new Scheme(Collections.<TypeVariable>emptyList(), type);
        }

        return new Scheme(Arrays.asList(variables), type);
    }

    public Type getType() {
        return type;
    }

    /**
     * Méthode d'instanciation d'un scheme
     * @param env Le contexte d'inférence
     * @return Un type instancié
     */
    public Type instantiate(Infer env) {
        List<TypeVariable> freshVariables = new LinkedList<>();
        variables.forEach(v -> freshVariables.add(env.createFreshTypeVariable()));
        Substitution substitution = new Substitution(variables, freshVariables);
        return this.type.apply(substitution);
    }

    @Override
    public Scheme apply(Substitution substitution) {
        List<TypeVariable> newList = new ArrayList<>();
        for (TypeVariable tv : variables) {
            newList.add((TypeVariable) tv.apply(substitution));
        }
        Type newType = type.apply(substitution);
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
