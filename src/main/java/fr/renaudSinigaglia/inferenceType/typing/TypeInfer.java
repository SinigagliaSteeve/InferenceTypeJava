package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.unification.Unifiable;

import java.util.*;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeInfer {

    private List<Constraint> constraints;
    private List<TypeVariable> tvs = new ArrayList();
    private TypeEnv typeEnv;


    public TypeInfer() {
        this.constraints = new ArrayList();
        this.typeEnv = new TypeEnv();
    }

    private TypeInfer(TypeInfer parent) {
        constraints = parent.constraints;
        typeEnv = parent.typeEnv;
    }


    public TypeVariable createFreshTypeVariable() {
        TypeVariable tv = FreshVariableBuilder.createFreshTypeVariable();
        tvs.add(tv);
        return tv;
    }

    public TypeInfer inEnv(Var var, Scheme scheme) {
        TypeInfer local = new TypeInfer(this);
        local.typeEnv.remove(var);
        local.typeEnv.extend(var, scheme);
        return local;
    }

    public Scheme lookupEnv(Var variable) {
        return typeEnv.lookup(variable);
    }

    public Scheme generalize(Type type) {
        Set<TypeVariable> setA = type.ftv();
        Set<TypeVariable> setB = typeEnv.ftv();
        setA.removeAll(setB);
        ArrayList<TypeVariable> tvList = new ArrayList<>();
        tvList.addAll(setA);
        return new Scheme(tvList, type);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public void uni(Type t1, Type t2) {
        this.constraints.add(new Constraint(t1, t2));
    }
}
