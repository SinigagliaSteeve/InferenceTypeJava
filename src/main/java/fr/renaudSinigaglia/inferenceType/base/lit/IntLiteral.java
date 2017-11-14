package fr.renaudSinigaglia.inferenceType.base.lit;

import fr.renaudSinigaglia.inferenceType.base.Literal;
import fr.renaudSinigaglia.inferenceType.typing.Int;
import fr.renaudSinigaglia.inferenceType.typing.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class IntLiteral extends Literal {

    @Override
    public Type infer() {
        return new Int();
    }
}
