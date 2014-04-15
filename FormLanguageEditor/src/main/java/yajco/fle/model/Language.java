package yajco.fle.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DeeL
 */
public class Language {
    List<Concept> concepts = new ArrayList<>();

    public List<Concept> getConcepts() {
        return concepts;
    }
    
    public Concept getBaseConcept() {
        return concepts.get(0);
    }
}
