package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.*;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Lam extends Expr {
    private Var variable;
    private Expr expression;

    public Lam(Var variable, Expr expression) {
        this.variable = variable;
        this.expression = expression;
    }

    public Type infer(TypeInfer typeInfer) {
        TypeVariable tv = typeInfer.createFreshTypeVariable();
        TypeInfer localEnv = typeInfer.inEnv(this.variable, Scheme.forAll(tv));
        Type res = expression.infer(localEnv);
        return new TypeArrow(tv, res);
    }

}
