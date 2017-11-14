package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

import java.util.List;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Lam implements Expr {
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

    @Override
    public Type infer() {
        TypeVariable tv = TypeInfer.getInstance().getEnv().createFreshTypeVariable();

        return null;
    }
}
