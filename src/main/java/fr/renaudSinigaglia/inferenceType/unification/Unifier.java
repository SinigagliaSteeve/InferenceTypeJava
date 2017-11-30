package fr.renaudSinigaglia.inferenceType.unification;

import fr.renaudSinigaglia.inferenceType.exception.UnificationFailException;
import fr.renaudSinigaglia.inferenceType.exception.UnificationMismatchException;
import fr.renaudSinigaglia.inferenceType.solver.Constraint;
import fr.renaudSinigaglia.inferenceType.substitution.Substitution;
import fr.renaudSinigaglia.inferenceType.exception.InfiniteTypeException;
import fr.renaudSinigaglia.inferenceType.type.*;

import java.util.ArrayList;

/**
 * Created by damien on 03/11/2017.
 */
public class Unifier {

    public static Substitution bind(TypeVariable tVar, Type type) {
        if (tVar.equals(type)) {
            return new Substitution();
        }
        if (type.ftv().contains(tVar)) {
            throw new InfiniteTypeException(tVar, type);
        }
        return new Substitution(tVar, type);
    }

    public static Substitution unifies(Constraint constraint) {
        if(constraint.getT1() == constraint.getT2()) {
            return new Substitution();
        }

        if(constraint.getT2() instanceof TypeVariable) {
            return bind((TypeVariable) constraint.getT2(), constraint.getT1());
        }

        if(constraint.getT1() instanceof TypeVariable) {
            return bind((TypeVariable) constraint.getT1(), constraint.getT2());
        }


        if(constraint.getT1() instanceof TypeArrow && constraint.getT2() instanceof TypeArrow) {
            TypeArrow typeArrow1 = (TypeArrow) constraint.getT1();
            TypeArrow typeArrow2 = (TypeArrow) constraint.getT2();


            ArrayList<Type> list1 = new ArrayList<>();
            list1.add(typeArrow1.getTypeLeft());
            list1.add(typeArrow1.getTypeRight());

            ArrayList<Type> list2 = new ArrayList<>();
            list2.add(typeArrow2.getTypeLeft());
            list2.add(typeArrow2.getTypeRight());
            TypeList tuple1 = new TypeList(list1);
            TypeList tuple2 = new TypeList(list2);


            return unifyMany(tuple1, tuple2);
        }

        throw new UnificationFailException(constraint.getT1(), constraint.getT2());
    }

    public static Substitution unifyMany(TypeList t1, TypeList t2) {
        boolean t1IsNull = t1.isEmpty();
        boolean t2IsNull = t2.isEmpty();
        if(t1IsNull && t2IsNull){
            return new Substitution();
        }

        if(t1IsNull || t2IsNull) {
            throw new UnificationMismatchException(t1, t2);
        }

        Substitution su1 = unifies(new Constraint(t1.head(), t2.head()));
        Substitution su2 = unifyMany(t1.apply(su1), t2.apply(su1));
        return su2.compose(su1);
    }
}
