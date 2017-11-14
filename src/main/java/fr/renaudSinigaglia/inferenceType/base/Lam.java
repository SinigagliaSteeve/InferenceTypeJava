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

    public Var getVariable() {
        return variable;
    }

    public void setVariable(Var variable) {
        this.variable = variable;
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    public Type infer(TypeInfer typeInfer) {
        TypeVariable tv = typeInfer.createFreshTypeVariable();
        TypeInfer localEnv = typeInfer.inEnv(this.variable, Scheme.forAll(tv));
        Type res = expression.infer(localEnv);
        return new TypeArray(tv, res);
    }


//    @Override
//    public Type infer() {
//        TypeVariable tv = TypeInfer.getInstance().getEnv().createFreshTypeVariable();
//
//        return null;
//    }
}
