package test;

import fr.renaudSinigaglia.inferenceType.base.App;
import fr.renaudSinigaglia.inferenceType.base.Lam;
import fr.renaudSinigaglia.inferenceType.base.Let;
import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.base.lit.Bool;
import fr.renaudSinigaglia.inferenceType.solver.Solver;
import fr.renaudSinigaglia.inferenceType.substitution.Subst;
import fr.renaudSinigaglia.inferenceType.typing.Type;
import fr.renaudSinigaglia.inferenceType.typing.TypeInfer;

/**
 * Created by damien on 29/10/2017.
 */
public class Main {

    public static void main(String[] args) {

        // let f = (\x -> x) in (\z y -> z) (f True) (f (1::Int))

        // True
        Bool boolExp = new Bool(true);
        Type t = boolExp.infer();
        System.out.println(t);

        // (\x -> True)
        Lam lamExp = new Lam(new Var("x"),boolExp);
        Type t2 = lamExp.infer();
        System.out.println(t2);

        // let f = (\x -> x) in (f True)
        Var f = new Var("f");
        Var x = new Var("x");
        Lam l = new Lam(x, x);
        App app = new App(f, new Bool(true));
        Let expFinal = new Let(f, l, app);

        TypeInfer infer = new TypeInfer();
        Type t3 = expFinal.infer(infer);
        Solver solver = new Solver();
        Subst s = solver.runSolve(infer.getConstraints());
        Type theType = t3.apply(s);
        System.out.println(t3);
        System.out.println(theType);
    }
}
