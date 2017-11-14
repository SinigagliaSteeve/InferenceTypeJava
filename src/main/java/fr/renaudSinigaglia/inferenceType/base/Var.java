package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Var implements Expr {
    private String name;

    public Var(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type infer() {
        return null;
    }
}
