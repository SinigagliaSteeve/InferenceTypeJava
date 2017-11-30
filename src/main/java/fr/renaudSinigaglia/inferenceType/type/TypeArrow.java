package fr.renaudSinigaglia.inferenceType.type;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 *
 * Classe représentant les types complexes (ex: x -> y)
 */
public class TypeArrow extends Type {
    private Type typeLeft;
    private Type typeRight;

    public TypeArrow(Type typeLeft, Type typeRight) {
        this.typeLeft = typeLeft;
        this.typeRight = typeRight;
    }

    public Type getTypeLeft() {
        return typeLeft;
    }

    public Type getTypeRight() {
        return typeRight;
    }

    @Override
    public TypeArrow apply(Substitution substitution) {
        return new TypeArrow(typeLeft.apply(substitution), typeRight.apply(substitution));
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(typeLeft.ftv());
        set.addAll(typeRight.ftv());
        return set;
    }

    @Override
    public String toString() {
        return typeLeft + " -> " + typeRight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeArrow typeArrow = (TypeArrow) o;

        if (typeLeft != null ? !typeLeft.equals(typeArrow.typeLeft) : typeArrow.typeLeft != null) return false;
        return typeRight != null ? typeRight.equals(typeArrow.typeRight) : typeArrow.typeRight == null;
    }

    @Override
    public int hashCode() {
        int result = typeLeft != null ? typeLeft.hashCode() : 0;
        result = 31 * result + (typeRight != null ? typeRight.hashCode() : 0);
        return result;
    }
}

