package fr.renaudSinigaglia.inferenceType.unification;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * Created by damien on 03/11/2017.
 */
public class Unifier {

    public static void uni(Type t1, Type t2) {
        TypeInfer.getInstance().addConstraint(t1, t2);
    }
}
