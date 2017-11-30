package fr.renaudSinigaglia.inferenceType.type;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;

import java.util.HashSet;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 *
 * Classe représentant un type terminal
 */
public class TypeCon extends Type {
    private String nameType;

    public TypeCon(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public TypeCon apply(Substitution substitution) {
        return this;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        return new HashSet<>();
    }

    @Override
    public String toString() {
        return nameType;
    }

}
