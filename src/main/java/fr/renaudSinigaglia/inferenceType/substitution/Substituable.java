package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashSet;

/**
 * Created by damien on 21/11/2017.
 */
public interface Substituable<T> {

    T apply(Substitution substitution);

    HashSet<TypeVariable> ftv();
}
