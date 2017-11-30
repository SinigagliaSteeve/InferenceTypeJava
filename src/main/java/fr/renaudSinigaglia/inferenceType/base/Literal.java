package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.inference.Infer;
import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public abstract class Literal<T> extends Expr {
    private T value;
    private Type type;

    public Literal(T value, Type type) {
        this.value = value;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Type infer(Infer infer) {
        return this.type;
    }

}
