package test;

import fr.renaudSinigaglia.inferenceType.base.App;
import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Let;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Bool;
import fr.renaudSinigaglia.inferenceType.typing.Type;

/**
 * Created by damien on 29/10/2017.
 */
public class Main {

    public static void main(String[] args) {

        // let f = (\x -> x) in (\z y -> z) (f True) (f (1::Int))

        Bool boolExp = new Bool(true);
        Type t = boolExp.infer();
        System.out.println(t);

        Lam lamExp = new Lam(new Var("x"),boolExp);
        Type t2 = lamExp.infer();
        System.out.println(t2);

        Let letExp = new Let(new Var("x"), new Lam(), lamExp);


    }
}
