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

    public Type runInfer() {
        Infer infer = new Infer();
        Type type = infer(infer);
        Solver solver = new Solver();
        Substitution substitution = solver.runSolve(infer.getConstraints());
        System.out.println("Last substitution : " + substitution);
        return type.apply(substitution);
    }

    public abstract Type infer(Infer infer);
}
