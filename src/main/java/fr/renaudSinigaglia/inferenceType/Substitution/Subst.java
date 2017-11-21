package fr.renaudSinigaglia.inferenceType.Substitution;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * Created by damien on 21/11/2017.
 */
public class Subst extends Substituable<Subst>{
    private HashMap<TypeVariable, Type> subst = new HashMap<>();

    @Override
    public Subst apply(Substituable subst) {
        return null;
    }

    @Override
    public HashSet<TypeVariable> ftv() {
        HashSet<TypeVariable> set = new HashSet<>();
        subst.values().forEach(type -> set.addAll(type.ftv())); // TODO Check ordonancement
        return set;
    }
}
