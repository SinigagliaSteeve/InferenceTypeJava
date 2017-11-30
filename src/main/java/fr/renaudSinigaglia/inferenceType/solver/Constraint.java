package fr.renaudSinigaglia.inferenceType.solver;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.substitution.Substituable;
import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public class Constraint implements Substituable<Constraint>{

    private Type t1;
    private Type t2;

    public Constraint(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;

    }

    @Override
    public Constraint apply(Substitution substitution) {
        Type tLeft = t1.apply(substitution);
        Type tRight = t2.apply(substitution);
        return new Constraint(tLeft, tRight);
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(t1.ftv());
        set.addAll(t2.ftv());
        return set;
    }

    public Type getT1() {
        return t1;
    }

    public Type getT2() {
        return t2;
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}
