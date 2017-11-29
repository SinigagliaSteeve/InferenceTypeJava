package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeArray extends Type<TypeArray> {
    private Type typeLeft;
    private Type typeRight;

    public TypeArray(Type typeLeft, Type typeRight) {
        this.typeLeft = typeLeft;
        this.typeRight = typeRight;
    }

    public Type getTypeLeft() {
        return typeLeft;
    }

    public void setTypeLeft(Type typeLeft) {
        this.typeLeft = typeLeft;
    }

    public Type getTypeRight() {
        return typeRight;
    }

    public void setTypeRight(Type typeRight) {
        this.typeRight = typeRight;
    }

    @Override
    public TypeArray apply(Subst subst) {
        return new TypeArray((Type)typeLeft.apply(subst), (Type)typeRight.apply(subst));
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

