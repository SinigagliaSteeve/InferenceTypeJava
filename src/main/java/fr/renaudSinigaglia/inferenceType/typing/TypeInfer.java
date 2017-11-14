package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.base.Expr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeInfer {

    private Env env;
    private List<Constraint> constraints;
    private Exception typeError;
    private InferState inferState;
    private Expr a;

    private static TypeInfer INSTANCE = new TypeInfer();

    private TypeInfer() {
        this.env = new Env();
        this.constraints = new ArrayList();
    }

    public static TypeInfer getInstance(){
        return INSTANCE;
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
