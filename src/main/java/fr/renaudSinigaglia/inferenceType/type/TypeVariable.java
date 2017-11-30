package fr.renaudSinigaglia.inferenceType.type;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 *
 * Notre objet représentant les variables de type
 */
public class TypeVariable extends Type {

    private String name;

    public TypeVariable(String name) {
        this.name = name;
    }

    /**
     * On applique la substitution à notre variable de type
     * @param substitution Une substitution
     * @return Le type substitué
     */
    @Override
    public Type apply(Substitution substitution) {
        return substitution.getSubsts().getOrDefault(this, this);
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        return new HashSet<>(Collections.singleton(this));
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeVariable that = (TypeVariable) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
