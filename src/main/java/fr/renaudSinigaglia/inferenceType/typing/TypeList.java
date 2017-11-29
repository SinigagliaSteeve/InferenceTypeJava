package fr.renaudSinigaglia.inferenceType.typing;

import fr.renaudSinigaglia.inferenceType.substitution.Subst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by damien on 29/11/2017.
 */
public class TypeList {

    private List<Type> typeList;

    public TypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public boolean isEmpty(){
        return typeList.isEmpty();
    }

    public TypeList apply(Subst subst) {
        return new TypeList(typeList.stream().map(type -> type.apply(subst)).collect(Collectors.toList()));
    }

    // get HEAD of list
    public Type getLeft() {
        if(typeList.isEmpty()) {
            return null;
        }
        Type head = typeList.get(0);
        typeList.remove(head);
        return head;
    }


}
