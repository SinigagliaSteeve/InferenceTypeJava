package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

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

    public T getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Type infer(TypeInfer typeInfer) {
        return this.type;
    }

}
