package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public abstract class Literal<T> extends Expr {
    @Override
    public Type infer(TypeInfer typeInfer) {
        return null;
    }
}
