package test;

import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Bool;
import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * Created by damien on 30/11/2017.
 */
public class TestLambda {
    public static void main(String[] args) {
        // (\x -> True)
        Lam lamExp = new Lam(new Var("x"), new Bool(true));
        Type t2 = lamExp.runInfer();
        System.out.println(t2 + " ?? tv0 -> Bool");
    }
}
