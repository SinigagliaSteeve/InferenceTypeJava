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

//    @Override
//    public Subst unifies(Type type) {
//        if (type instanceof TypeArrow) {
//            TypeArrow typeArray = (TypeArrow) type;
//            TypeList tuple1 = new TypeList(this.typeLeft, this.typeRight);
//            TypeList tuple2 = new TypeList(typeArray.typeLeft, typeArray.typeRight);
//            return unifyMany(tuple1, tuple2);
//        }
//        throw new UnificationFailException(this, type);
//    }

//    private Subst unifyMany(TypeArrow t1, TypeArrow t2) {
//        Subst subst1 = t1.typeLeft.unifies(t2.typeLeft);
//        Subst subst2 = t1.typeRight.apply(subst1).unifies(t2.typeRight.apply(subst1));
//        Subst substFinal = subst2.compose(subst1); //todo apply de sust.
//        return substFinal;
//
//    }
}

