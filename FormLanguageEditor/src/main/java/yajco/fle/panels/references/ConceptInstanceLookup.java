package yajco.fle.panels.references;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author Milan
 */
public class ConceptInstanceLookup extends Observable {
    
    // TODO: najst lepsie riesenie nez singleton
    private static final ConceptInstanceLookup instance = new ConceptInstanceLookup();
    
    // TODO: prerobit na sentence
    // TODO: bude List ok? ako riesit pripady ked je objekt dvakrat v kontexte? atp.
    private final Set<Object> context = new HashSet<>();
    
    private ConceptInstanceLookup() {}
    
    public static ConceptInstanceLookup getInstance() {
        return instance;
    }
    
    public void registerConceptInstance(Object instance) {
        context.add(instance);
        super.setChanged();
        super.notifyObservers();
    }
    
    public void unregisterConceptInstance(Object instance) {
        context.remove(instance);
        super.setChanged();
        super.notifyObservers();
    }
    
    public List<Object> getInstancesOfConcept(Class concept) {
        List<Object> retVal = new ArrayList<>();
        for(Object o : context) {
            if(concept.isAssignableFrom(o.getClass())) {
                retVal.add(o);
            }
        }
        return retVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Object object : context) {
            sb.append("\n").append(object);
        }
        return sb.toString();
    }
    
    
}
