package fr.renaudSinigaglia.inferenceType.typing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sinigaglia Steeve
 * @version 1.0.0
 */
public class Scheme {
    private List<TypeVariable> variables;
    private Type type;

    private Scheme(List<TypeVariable> variables, Type type) {
        this.variables = variables;
        this.type = type;
    }

    public static Scheme forAll(Type type, TypeVariable... variables) {
        if (variables.length == 0) { //todo watch if null?
            return new Scheme(Collections.<TypeVariable>emptyList(), type);
        }

        return new Scheme(Arrays.asList(variables), type);
    }
}
