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
    private HashMap<TypeVariable, Type> subst = new HashMap<>();

    public Subst(List<TypeVariable> variables, List<TypeVariable> freshVariables) {
        for (int i = 0; i < variables.size(); i++) {
            subst.put(variables.get(i), freshVariables.get(i));
        }
    }

    public Subst() {
    }

    private Subst(Subst prev) {
        subst.putAll(prev.subst);
    }

    public Subst(TypeVariable tVar, Type type) {
        subst.put(tVar, type);
    }

    public Subst compose(Subst sub) {
        Subst s = new Subst(sub);
        s.apply(this);
        subst.putAll(s.subst);
        return this;
    }

    @Override
    public Subst apply(Subst subst) {
        //TODO
        System.out.println("PASSED IN APPLY OF SUBST");
        return null;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        subst.values().forEach(type -> set.addAll(type.ftv()));
        return set;
    }

    public HashMap<TypeVariable, Type> getSubst() {
        return subst;
    }
}
