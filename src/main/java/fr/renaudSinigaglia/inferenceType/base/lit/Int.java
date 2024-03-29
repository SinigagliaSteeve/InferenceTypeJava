package fr.renaudSinigaglia.inferenceType.base.lit;

import fr.renaudSinigaglia.inferenceType.base.Literal;
import fr.renaudSinigaglia.inferenceType.type.TypeCon;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Int extends Literal<Integer> {

    public Int(Integer value) {
        super(value, new TypeCon("Int"));
    }

    @Override
    public String toString() {
        return "Int";
    }
}
