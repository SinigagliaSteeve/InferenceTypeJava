package fr.renaudSinigaglia.inferenceType.inference;

import fr.renaudSinigaglia.inferenceType.base.Var;
import fr.renaudSinigaglia.inferenceType.solver.Constraint;
import fr.renaudSinigaglia.inferenceType.type.*;

import java.util.*;

/**
 * Created by damien on 03/11/2017.
 */
public class Infer {

    private List<Constraint> constraints;
    private List<TypeVariable> tvs = new ArrayList();
    private Env env;


    public Infer() {
        this.constraints = new ArrayList();
        this.env = new Env();
    }

    /**
     * Utilisé pour créer un environnement local.
     * @param parent parent
     */
    private Infer(Infer parent) {
        constraints = parent.constraints;
        env = parent.env;
    }


    /**
     * Méthode permettant la création d'une freshVariable unique
     * @return TypeVariable avec nom unique
     */
    public TypeVariable createFreshTypeVariable() {
        TypeVariable tv = FreshVariableBuilder.createFreshTypeVariable();
        tvs.add(tv);
        return tv;
    }

    /**
     * Créer un environnement local (cas d'une Lambda Expr)
     * @param var variable qui est présente dans le contexte local
     * @param scheme scheme
     * @return Infer
     */
    public Infer inEnv(Var var, Scheme scheme) {
        Infer local = new Infer(this);
        local.env.remove(var);
        local.env.extend(var, scheme);
        return local;
    }

    /**
     * Check si la variable est présente dans l'environnement et retourne un Scheme.
     * @param variable variable à chercher dans l'env.
     * @return Scheme
     */
    public Scheme lookupEnv(Var variable) {
        return env.lookup(variable);
    }

    /**
     * Méthode créant un Scheme à partir d'un Type.
     * @param type type à généraliser.
     * @return un Type généralisé (Scheme)
     */
    public Scheme generalize(Type type) {
        Set<TypeVariable> setA = type.ftv();
        Set<TypeVariable> setB = env.ftv();
        setA.removeAll(setB);
        ArrayList<TypeVariable> tvList = new ArrayList<>();
        tvList.addAll(setA);
        return new Scheme(tvList, type);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public void uni(Type t1, Type t2) {
        this.constraints.add(new Constraint(t1, t2));
    }
}
