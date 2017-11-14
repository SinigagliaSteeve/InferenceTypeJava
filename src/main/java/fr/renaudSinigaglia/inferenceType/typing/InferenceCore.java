package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.base.Expr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damien on 08/11/2017.
 */
public class InferenceCore {

    private Env env;
    private List<Constraint> constraints;
    private Exception typeError;
    private InferState inferState;
    private Expr a;

    public InferenceCore() {
        this.env = new Env();
        this.constraints = new ArrayList();
    }

    public Type evalExpression(Expr expr) {
        Type t = expr.infer();
        return null;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public void addConstraint(Type t1, Type t2) {
        this.constraints.add(new Constraint(t1, t2));
    }

    public Exception getTypeError() {
        return typeError;
    }

    public void setTypeError(Exception typeError) {
        this.typeError = typeError;
    }

    public InferState getInferState() {
        return inferState;
    }

    public void setInferState(InferState inferState) {
        this.inferState = inferState;
    }

    public Expr getA() {
        return a;
    }

    public void setA(Expr a) {
        this.a = a;
    }
}
