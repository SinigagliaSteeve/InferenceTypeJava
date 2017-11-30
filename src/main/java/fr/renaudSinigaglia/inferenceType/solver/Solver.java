package fr.renaudSinigaglia.inferenceType.solver;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.unification.Unifier;

import java.util.List;

/**
 * Created by damien on 29/11/2017.
 *
 * Classe de résolution des constraintes
 */
public class Solver {


    /**
     * Méthode globale pour exécuter la résolution des contraintes
     * @param constraints la liste des contraintes
     * @return une substitution 'finale'
     */
    public Substitution runSolve(List<Constraint> constraints) {
        Substitution emptySubstitution = new Substitution();
        return solver(emptySubstitution, constraints);
    }


    /**
     * Méthode de résolution des contraintes
     * @param substitution la substitution qui sera "agrémentée" au fur et à mesure
     * @param constraints la liste des contraintes
     * @return une substitution
     */
    public Substitution solver(Substitution substitution, List<Constraint> constraints) {
        if (constraints.isEmpty()) {
            return substitution;
        }

        Constraint constraint = constraints.get(0);
        constraints.remove(0);
        Substitution su1 = Unifier.unifies(constraint);
        return solver(substitution.compose(su1), constraints);
    }
}
