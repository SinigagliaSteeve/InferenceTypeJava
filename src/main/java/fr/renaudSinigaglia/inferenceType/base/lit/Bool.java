package fr.renaudSinigaglia.inferenceType.base.lit;

import fr.renaudSinigaglia.inferenceType.base.Literal;
import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeCon;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Bool extends Literal<Boolean> {


    public Bool(Boolean value) {
        super(value, new TypeCon("Bool"));
    }

    @Override
    public String toString() {
        return "Bool";
    }
}
    