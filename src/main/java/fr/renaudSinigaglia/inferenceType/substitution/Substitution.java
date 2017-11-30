package fr.renaudSinigaglia.inferenceType.substitution;

import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by damien on 21/11/2017.
 *
 * Classe représentant les substitutions de notre algorithme
 */
public class Substitution implements Substituable<Substitution> {
    private HashMap<TypeVariable, Type> substs = new HashMap<>();

    public Substitution(List<TypeVariable> variables, List<TypeVariable> freshVariables) {
        for (int i = 0; i < variables.size(); i++) {
            substs.put(variables.get(i), freshVariables.get(i));
        }

        System.out.print("New Substitution ( ");
        for (TypeVariable tv : substs.keySet()) {
            System.out.print("("+tv+", "+substs.get(tv)+") ");
        }
        System.out.println(")");

    }

    public Substitution() {
    }

    private Substitution(Substitution prev) {
        substs.putAll(prev.substs);
        System.out.print("New Substitution (");
        for (TypeVariable tv : substs.keySet()) {
            System.out.print("("+tv+", "+substs.get(tv)+")");
        }
        System.out.println(")");
    }

    public Substitution(TypeVariable tVar, Type type) {
        substs.put(tVar, type);
    }

    /**
     * Fusionner deux substitutions en appliquant la première à la seconde
     * @param sub Une substitution
     * @return Une nouvelle substitution composée
     */
    public Substitution compose(Substitution sub) {
        Substitution result = new Substitution(sub.apply(this));
        result.substs.putAll(this.substs);
        return result;
    }

    @Override
    public Substitution apply(Substitution substitution) {
        Substitution result = new Substitution();
        for (Map.Entry<TypeVariable,Type> typeVariableTypeEntry : substs.entrySet()) {
            result.substs.put(typeVariableTypeEntry.getKey(), typeVariableTypeEntry.getValue().apply(substitution));
        }
        return result;
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

    @Override
    public String toString() {
        return "Substitution(" + substs + ')';
    }
}
