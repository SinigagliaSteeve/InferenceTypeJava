package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by damien on 21/11/2017.
 */
public class Substitution implements Substituable<Substitution> {
    private HashMap<TypeVariable, Type> substs = new HashMap<>();

    public Substitution(List<TypeVariable> variables, List<TypeVariable> freshVariables) {
        for (int i = 0; i < variables.size(); i++) {
            substs.put(variables.get(i), freshVariables.get(i));
        }
    }

    public Substitution() {
    }

    private Substitution(Substitution prev) {
        substs.putAll(prev.substs);
    }

    public Substitution(TypeVariable tVar, Type type) {
        substs.put(tVar, type);
    }

    public Substitution compose(Substitution sub) {
        Substitution s = new Substitution(sub);
        s.apply(this);
        substs.putAll(s.substs);
        return this;
    }

    @Override
    public Substitution apply(Substitution substitution) {
        this.substs.keySet().stream().forEach(tv -> tv.apply(substitution));
        return this;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        substs.values().forEach(type -> set.addAll(type.ftv()));
        return set;
    }

    public HashMap<TypeVariable, Type> getSubsts() {
        return substs;
    }
}
