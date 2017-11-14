package fr.renaudSinigaglia.inferenceType.typing;

/**
 * Created by damien on 03/11/2017.
 */
public class Constraint {

    private Type t1;
    private Type t2;

    public Constraint(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}
