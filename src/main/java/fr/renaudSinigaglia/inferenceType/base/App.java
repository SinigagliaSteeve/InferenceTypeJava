package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeArrow;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

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

    public Type infer(TypeInfer typeInfer) {
        Type t1 = leftExpr.infer(typeInfer);
        Type tr = rightExpr.infer(typeInfer);
        TypeVariable tv = typeInfer.createFreshTypeVariable();
        typeInfer.uni(t1, new TypeArrow(tr, tv));
        return tv;
    }

}
