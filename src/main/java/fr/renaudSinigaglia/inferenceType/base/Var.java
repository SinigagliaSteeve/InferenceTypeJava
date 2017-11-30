package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

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
    public Type infer(TypeInfer typeInfer) {
        return typeInfer.lookupEnv(this).instantiate(typeInfer);
    }
}
