package fr.renaudSinigaglia.inferenceType.unification;

import fr.renaudSinigaglia.inferenceType.Substitution.Subst;
import fr.renaudSinigaglia.inferenceType.exception.InfiniteTypeException;
import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;
import fr.renaudSinigaglia.inferenceType.typing.TypeVariable;

/**
 * Created by damien on 03/11/2017.
 */
public interface Unifiable {

    Subst unifies(Type type);

    default Subst bind(TypeVariable tVar, Type type) {
        if (tVar.equals(type)) {
            return new Subst();
        }
        if (type.ftv().contains(tVar)) {
            throw new InfiniteTypeException(tVar, type);
        }
        return new Subst(tVar, type);
    }
}
