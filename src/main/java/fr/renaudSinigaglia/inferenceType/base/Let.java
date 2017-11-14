package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Scheme;
import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

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

    public Type infer(TypeInfer typeInfer) {
        //ask = typeInfer
        Type t1 = leftExpr.infer(typeInfer);
        Scheme sc = typeInfer.generalize(t1); //generalize env t1 TODOz
        TypeInfer localEnv = typeInfer.inEnv(this.variable, sc);
        Type t2 = rightExpr.infer(localEnv);
        return t2;
    }
}
