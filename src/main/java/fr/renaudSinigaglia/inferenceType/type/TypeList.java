package fr.renaudSinigaglia.inferenceType.type;

import fr.renaudSinigaglia.inferenceType.substitution.Substitution;

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

    public TypeList apply(Substitution substitution) {
        return new TypeList(typeList.stream().map(type -> type.apply(substitution)).collect(Collectors.toList()));
    }

    // get HEAD of list
    public Type head() {
        if(typeList.isEmpty()) {
            return null;
        }
        Type head = typeList.get(0);
        typeList.remove(head);
        return head;
    }


}
