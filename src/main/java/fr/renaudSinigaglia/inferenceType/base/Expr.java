package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.solver.Solver;
import fr.renaudSinigaglia.inferenceType.substitution.Subst;
import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public abstract class Expr {

    public Type runInfer() {
        TypeInfer typeInfer = new TypeInfer();
        Type type = infer(typeInfer);
        Solver solver = new Solver();
        Subst subst = solver.runSolve(typeInfer.getConstraints());
        return type.apply(subst);
    }

    public abstract Type infer(TypeInfer typeInfer);
}
