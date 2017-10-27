package fr.renaudSinigaglia.inferenceType.base;

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
}
