package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

import java.util.HashSet;

/**
 * Created by damien on 21/11/2017.
 */
public interface Substituable<T> {

    T apply(Subst subst);

    HashSet<TypeVariable> ftv();
}
