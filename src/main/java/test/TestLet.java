package test;

import fr.renaudSinigaglia.inferenceType.base.App;
import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Let;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Int;
import fr.renaudSinigaglia.inferenceType.type.Type;

/**
 * Created by damien on 30/11/2017.
 */


public class TestLet {

    public static void main(String[] args) {
        // let f = (\x -> x) in (f True)
        Var f = new Var("f");
        Var x = new Var("x");
        Lam l = new Lam(x, x);
        App app = new App(f, new Int(4));
        Let expFinal = new Let(f, l, app);

        Type t3 = expFinal.runInfer();
        System.out.println(t3 + " ?? Int");
    }


}
