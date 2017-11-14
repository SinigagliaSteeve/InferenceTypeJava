package fr.renaudSinigaglia.inferenceType.typing;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class TypeCon extends Type{
    private String nameType;

    public TypeCon(String nameType) {
        this.nameType = nameType;
    }

    public String getNameType() {
        return nameType;
    }
}
