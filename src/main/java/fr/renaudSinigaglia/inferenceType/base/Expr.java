package fr.renaudSinigaglia.inferenceType.base;

import fr.renaudSinigaglia.inferenceType.typing.Type;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public interface Expr{

    Type infer();

}
