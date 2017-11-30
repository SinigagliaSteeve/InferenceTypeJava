package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.substitution.Subst;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
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
    public TypeArrow apply(Subst subst) {
        return new TypeArrow(typeLeft.apply(subst), typeRight.apply(subst));
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
}

