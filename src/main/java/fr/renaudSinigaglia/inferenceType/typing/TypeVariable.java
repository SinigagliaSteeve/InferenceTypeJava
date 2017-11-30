package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.substitution.Subst;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeVariable extends Type {

    private String name;

    public TypeVariable(String name) {
        this.name = name;
    }

    @Override
    public Type apply(Subst subst) {
        Type t = subst.getSubst().get(this);
        if (t != null) {
            return t;
        }
        return this;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        return new HashSet<>(Collections.singleton(this));
    }

    @Override
    public String toString() {
        return name;
    }

}
