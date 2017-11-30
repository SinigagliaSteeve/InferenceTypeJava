package test;

import fr.renaudSinigaglia.inferenceType.base.App;
import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Let;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Bool;
import fr.renaudSinigaglia.inferenceType.base.lit.Int;
import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * Created by damien on 29/10/2017.
 */
public class TestComplex1 {

    public static void main(String[] args) {
        // let a = (\ u -> u) in (\v -> v) (a True)
        Var a = new Var("a");
        Var u = new Var("u");
        Var v = new Var("v");
//        Var w = new Var("w");
        Lam lamX = new Lam(u, u);
        App appBool = new App(a, new Bool(true));
//        App appInt = new App(a, new Int(4));
        Lam lamB = new Lam(v, v);

        App appF = new App(lamB, appBool);

        Let letFinal = new Let(a, lamX, appF);
        System.out.println(letFinal.runInfer() + " ?? Bool");

    }
}
