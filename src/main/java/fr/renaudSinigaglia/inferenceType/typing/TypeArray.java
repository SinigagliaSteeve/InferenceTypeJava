package fr.renaudSinigaglia.inferenceType.typing;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeArray extends Type {
    private Type typeLeft;
    private Type typeRight;

    public TypeArray(Type typeLeft, Type typeRight) {
        this.typeLeft = typeLeft;
        this.typeRight = typeRight;
    }

    public Type getTypeLeft() {
        return typeLeft;
    }

    public void setTypeLeft(Type typeLeft) {
        this.typeLeft = typeLeft;
    }

    public Type getTypeRight() {
        return typeRight;
    }

    public void setTypeRight(Type typeRight) {
        this.typeRight = typeRight;
    }
}
