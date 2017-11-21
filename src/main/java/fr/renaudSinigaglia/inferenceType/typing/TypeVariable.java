package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeVariable extends Type<TypeVariable>{

    private String name;
    private Type type;

    public TypeVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public TypeVariable apply(Substituable subst) {
        return null;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        return new HashSet<>(Collections.singleton(this));
    }
}
