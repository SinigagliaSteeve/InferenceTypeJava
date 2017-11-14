package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeArray;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;
import fr.renaudSinigaglia.inferenceType.unification.Unifier;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class App implements Expr {
    private Expr leftExpr;
    private Expr rightExpr;

    public App(Expr leftExpr, Expr rightExpr) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    public Expr getLeftExpr() {
        return leftExpr;
    }

    public void setLeftExpr(Expr leftExpr) {
        this.leftExpr = leftExpr;
    }

    public Expr getRightExpr() {
        return rightExpr;
    }

    public void setRightExpr(Expr rightExpr) {
        this.rightExpr = rightExpr;
    }

    @Override
    public Type infer() {
        Type t1 = leftExpr.infer();
        Type t2 = rightExpr.infer();
        TypeVariable tv = TypeInfer.getInstance().getEnv().createFreshTypeVariable();
        Unifier.uni(t1, new TypeArray(t2, tv));
        return tv;
    }
}
