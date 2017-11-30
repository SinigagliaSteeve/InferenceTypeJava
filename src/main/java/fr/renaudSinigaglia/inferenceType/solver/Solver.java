package fr.renaudSinigaglia.inferenceType.solver;

import fr.renaudSinigaglia.inferenceType.substitution.Subst;
import fr.renaudSinigaglia.inferenceType.typing.Constraint;
import fr.renaudSinigaglia.inferenceType.unification.Unifier;

import java.util.List;

/**
 * Created by damien on 29/11/2017.
 */
public class Solver {

    public Subst runSolve(List<Constraint> constraints) {
        Subst emptySubst = new Subst();
        return solver(emptySubst, constraints);
    }


    public Subst solver(Subst subst, List<Constraint> constraints) {
        if (constraints.isEmpty()) {
            return subst;
        }

        Constraint constraint = constraints.get(0);
        constraints.remove(0);
        Subst su1 = Unifier.unifies(constraint);
        return solver(subst.compose(su1), constraints);
    }
}
