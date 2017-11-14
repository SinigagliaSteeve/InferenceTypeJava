package fr.renaudSinigaglia.inferenceType.typing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damien on 03/11/2017.
 */
public class Env {

    private List<TypeVariable> tvs = new ArrayList();

    private int count = 0;

    public TypeVariable createFreshTypeVariable(){
        TypeVariable tv = new TypeVariable("tv" + count);
        tvs.add(tv);
        count++;
        return tv;
    }
}
