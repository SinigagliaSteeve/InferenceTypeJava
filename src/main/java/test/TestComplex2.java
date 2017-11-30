package test;

import fr.renaudSinigaglia.inferenceType.base.App;
import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Let;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Bool;
import fr.renaudSinigaglia.inferenceType.base.lit.Int;

/**
 * Created by damien on 29/10/2017.
 */
public class TestComplex2 {

    public static void main(String[] args) {

        // let f = (\x -> x) in (\z y -> z) (f True) (f (1::Int))

        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        Var f = new Var("f");

        Lam lamX = new Lam(x, x);
        Lam lamYZ = new Lam(y, new Lam(z, z));

        App appBool = new App(f, new Bool(true));
        App appInt = new App(f, new Int(1));

        App superApp = new App(new App(lamYZ,appBool),appInt);

        Let letFinal = new Let(f, lamX, superApp);
        System.out.println(letFinal.runInfer() + " ?? Int");

    }
}
