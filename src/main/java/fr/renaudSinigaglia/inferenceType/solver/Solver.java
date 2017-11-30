package fr.renaudSinigaglia.inferenceType.solver;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.unification.Unifier;

import java.util.List;

/**
 * Created by damien on 29/11/2017.
 */
public class Solver {

    public Substitution runSolve(List<Constraint> constraints) {
        Substitution emptySubstitution = new Substitution();
        return solve(emptySubstitution, constraints);
    }


    public Substitution solve(Substitution substitution, List<Constraint> constraints) {
        if (constraints.isEmpty()) {
            return substitution;
        }

        Constraint constraint = constraints.get(0);
        constraints.remove(0);
        Substitution su1 = Unifier.unifies(constraint);
        return solve(substitution.compose(su1), constraints);
    }
}
