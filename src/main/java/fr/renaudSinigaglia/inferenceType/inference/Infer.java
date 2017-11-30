package fr.renaudSinigaglia.inferenceType.inference;

import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.solver.Constraint;
import fr.renaudSinigaglia.inferenceType.type.*;

import java.util.*;

/**
 * Created by damien on 03/11/2017.
 */
public class Infer {

    private List<Constraint> constraints;
    private Env env;


    public Infer() {
        this.constraints = new ArrayList();
        this.env = new Env();
    }

    private Infer(Infer parent) {
        constraints = parent.constraints;
        env = parent.env;
    }


    public TypeVariable createFreshTypeVariable() {
        TypeVariable tv = FreshVariableBuilder.createFreshTypeVariable();
        return tv;
    }

    public Infer inEnv(Var var, Scheme scheme) {
        Infer local = new Infer(this);
        local.env.remove(var);
        local.env.extend(var, scheme);
        return local;
    }

    public Scheme lookupEnv(Var variable) {
        return env.lookup(variable);
    }

    public Scheme generalize(Type type) {
        Set<TypeVariable> setA = type.ftv();
        Set<TypeVariable> setB = env.ftv();
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
        System.out.println("New Constraint ( " + t1 + ", " + t2 + ")");
        this.constraints.add(new Constraint(t1, t2));
    }

    public void removeTypeFromEnv(Var variable) {
        Infer local = new Infer(this);
        local.env.remove(variable);
    }
}
