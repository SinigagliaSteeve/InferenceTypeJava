package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.inference.Infer;
import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.type.TypeArrow;
import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class App extends Expr {
    private Expr leftExpr;
    private Expr rightExpr;

    public App(Expr leftExpr, Expr rightExpr) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    public Type infer(Infer infer) {
        Type t1 = leftExpr.infer(infer);
        Type tr = rightExpr.infer(infer);
        TypeVariable tv = infer.createFreshTypeVariable();
        infer.uni(t1, new TypeArrow(tr, tv));
        return tv;
    }

    @Override
    public String toString() {
        return "App("+leftExpr+", "+rightExpr+")";
    }
}
