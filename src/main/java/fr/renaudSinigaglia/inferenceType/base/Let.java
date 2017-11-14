package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Let implements Expr {
    private Var variable;
    private Expr leftExpr;
    private Expr rightExpr;

    public Let(Var variable, Expr leftExpr, Expr rightExpr) {
        this.variable = variable;
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    public Var getVariable() {
        return variable;
    }

    public void setVariable(Var variable) {
        this.variable = variable;
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
        return null;
    }
}
