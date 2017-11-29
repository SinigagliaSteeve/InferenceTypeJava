package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.substitution.Substituable;
import fr.renaudSinigaglia.inferenceType.unification.Unifiable;

/**
 * Created by damien on 03/11/2017.
 */
public abstract class Type implements Substituable<Type> {

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