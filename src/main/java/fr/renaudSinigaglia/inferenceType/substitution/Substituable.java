package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashSet;

/**
 * Created by damien on 21/11/2017.
 *
 * Interface fournissant deux méthodes
 */
public interface Substituable<T> {

    /**
     * Méthode appliquant une substitution à une élément de type T
     * @param substitution la substitution à appliquer
     * @return Un élément de type T
     */
    T apply(Substitution substitution);

    /**
     * Méthode permettant de récupérer l'ensemble des variables de type libres d'un objet substituable
     * @return
     */
    HashSet<TypeVariable> ftv();
}
