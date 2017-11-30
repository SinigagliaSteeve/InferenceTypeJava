package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.type.Scheme;
import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.inference.Infer;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Let extends Expr {
    private Var variable;
    private Expr leftExpr;
    private Expr rightExpr;

    public Let(Var variable, Expr leftExpr, Expr rightExpr) {
        this.variable = variable;
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    public Type infer(Infer infer) {
        //ask = infer
        Type t1 = leftExpr.infer(infer);
        Scheme sc = infer.generalize(t1);
        Infer localEnv = infer.inEnv(this.variable, sc);
        Type t2 = rightExpr.infer(localEnv);
        return t2;
    }

    @Override
    public String toString() {
        return "Let("+variable+" = " + leftExpr + " in " + rightExpr + ")";
    }
}
