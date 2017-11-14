package fr.renaudSinigaglia.inferenceType.typing;

/**
 * Created by damien on 03/11/2017.
 */
public class TypeVariable extends Type{

    private String name;
    private Type type;

    public TypeVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
