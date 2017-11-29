package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;
import fr.renaudSinigaglia.inferenceType.exception.UnificationFailException;

import java.util.HashSet;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class TypeCon extends Type<TypeCon> {
    private String nameType;

    public TypeCon(String nameType) {
        this.nameType = nameType;
    }

    public String getNameType() {
        return nameType;
    }

    @Override
    public TypeCon apply(Subst subst) {
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

    @Override
    public Subst unifies(Type type) {
        throw new UnificationFailException(this, type);
    }
}
