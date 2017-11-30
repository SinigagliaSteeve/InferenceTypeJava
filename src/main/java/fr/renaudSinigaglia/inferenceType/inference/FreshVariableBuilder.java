package fr.renaudSinigaglia.inferenceType.inference;

import fr.renaudSinigaglia.inferenceType.type.TypeVariable;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class FreshVariableBuilder {

    private static int counter =0;


    public static TypeVariable createFreshTypeVariable() {
        TypeVariable tv = new TypeVariable("tv" + counter);
        counter++;
        return tv;
    }
}
