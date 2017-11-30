package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by damien on 21/11/2017.
 */
public class Subst implements Substituable<Subst> {
    private HashMap<TypeVariable, Type> substs = new HashMap<>();

    public Subst(List<TypeVariable> variables, List<TypeVariable> freshVariables) {
        for (int i = 0; i < variables.size(); i++) {
            substs.put(variables.get(i), freshVariables.get(i));
        }
    }

    public Subst() {
    }

    private Subst(Subst prev) {
        substs.putAll(prev.substs);
    }

    public Subst(TypeVariable tVar, Type type) {
        substs.put(tVar, type);
    }

    public Subst compose(Subst sub) {
        Subst s = new Subst(sub);
        s.apply(this);
        substs.putAll(s.substs);
        return this;
    }

    @Override
    public Subst apply(Subst subst) {
        //TODO
        this.substs.keySet().stream().forEach(tv -> tv.apply(subst));
        return this;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        substs.values().forEach(type -> set.addAll(type.ftv())); // TODO Check ordonancement
        return set;
    }

    public HashMap<TypeVariable, Type> getSubsts() {
        return substs;
    }
}
