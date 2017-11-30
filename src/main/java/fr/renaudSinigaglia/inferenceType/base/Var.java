package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.type.Type;
import fr.renaudSinigaglia.inferenceType.inference.Infer;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Var extends Expr {
    private String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public Type infer(Infer infer) {
        return infer.lookupEnv(this).instantiate(infer);
    }
}
