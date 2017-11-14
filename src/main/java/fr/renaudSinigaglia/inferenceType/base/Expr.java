package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public abstract class Expr {

    public Type infer() {
        TypeInfer typeInfer = new TypeInfer();
        Type type = infer(typeInfer);
        return type;
    }

    public abstract Type infer(TypeInfer typeInfer);
}
