package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.base.Expr;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.unification.Unifiable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeInfer implements Unifiable {

    private List<Constraint> constraints;
    private List<TypeVariable> tvs = new ArrayList();

    private Exception typeError;
    private InferState inferState;
    private Expr a;
    private int count = 0;


    public TypeInfer() {
        this.constraints = new ArrayList();
    }

    private TypeInfer(TypeInfer parent) {
        //todo
    }


    public TypeVariable createFreshTypeVariable() {
        TypeVariable tv = new TypeVariable("tv" + count);
        tvs.add(tv);
        count++;
        return tv;
    }

    public TypeInfer inEnv(Var var, Scheme scheme) {
        TypeInfer local = new TypeInfer(this);
        //todo
        return local;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
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

    public void uni(Type t1, Type t2) {
        this.constraints.add(new Constraint(t1, t2));
    }
}
