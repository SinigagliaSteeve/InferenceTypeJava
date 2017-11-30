package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.solver.Solver;
import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.inference.Infer;
import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public abstract class Expr {

    /**
     * Cette méthode permet de lancer l'algorithme en démarrant l'inférence
     * et la résolution des contraintes.
     * @return
     */
    public Type runInfer() {
        Infer infer = new Infer();
        Type type = infer(infer);
        Solver solver = new Solver();
        Substitution substitution = solver.runSolve(infer.getConstraints());
        return type.apply(substitution);
    }

    public abstract Type infer(Infer infer);
}
