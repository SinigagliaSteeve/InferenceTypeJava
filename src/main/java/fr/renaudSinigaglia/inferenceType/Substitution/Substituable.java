package fr.renaudSinigaglia.inferenceType.Substitution;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

import java.util.HashSet;

/**
 * Created by damien on 21/11/2017.
 */
public abstract class Substituable<T extends Substituable<T>> {

    public abstract T apply(Substituable subst);

    public abstract HashSet<TypeVariable> ftv();
}
