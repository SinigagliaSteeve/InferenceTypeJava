package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.Substitution.Substituable;
import fr.renaudSinigaglia.inferenceType.unification.Unifiable;

import java.util.HashSet;

/**
 * Created by damien on 03/11/2017.
 */
public abstract class Type<T> extends Substituable implements Unifiable {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}