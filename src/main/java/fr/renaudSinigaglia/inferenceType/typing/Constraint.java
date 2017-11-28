package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;
import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public class Constraint extends Substituable<Constraint>{

    private Type t1;
    private Type t2;

    public Constraint(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public Constraint apply(Subst subst) {
        // TODO WARNING C'est étrange
        Type tLeft = (Type) t1.apply(subst);
        Type tRight= (Type) t2.apply(subst);
        return new Constraint(tLeft, tRight);
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        set.addAll(t1.ftv());
        set.addAll(t2.ftv());
        return set;
    }
}
