package fr.renaudSinigaglia.inferenceType.unification;

import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * Created by damien on 03/11/2017.
 */
public interface Unifiable {

    void uni(Type t1, Type t2);
}
