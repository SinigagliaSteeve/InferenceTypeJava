package fr.renaudSinigaglia.inferenceType.base;

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
}
