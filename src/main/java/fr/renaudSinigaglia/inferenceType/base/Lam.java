package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.inference.Infer;
import fr.renaudSinigaglia.inferenceType.type.*;

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

    public Type infer(Infer infer) {
        TypeVariable tv = infer.createFreshTypeVariable();
        Infer localEnv = infer.inEnv(this.variable, Scheme.forAll(tv));
        Type res = expression.infer(localEnv);
        infer.removeTypeFromEnv(this.variable);
        return new TypeArrow(tv, res);
    }

    @Override
    public String toString() {
        return "Lam(\\"+variable+" -> "+expression+")";
    }
}
