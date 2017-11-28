package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public abstract class Type<T> extends Substituable<Type>{

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    @Override
//    public Type apply(Substituable subst) {
//        return null;
//    }

    //    public Type apply(Substituable subst, Type a) {
//        if(a instanceof TypeCon)
//            return a;
//        return null;
//    }
//
//    public HashSet<TypeVariable> ftv(Type a) {
//        return null;
//    }
}

