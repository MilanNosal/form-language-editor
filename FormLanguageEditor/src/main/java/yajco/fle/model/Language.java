package yajco.fle.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DeeL
 */
public class Language {

    private final List<Concept> concepts;

    public Language(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public Concept getMainConcept() {
        return concepts.get(0);
    }

    @Override
    public String toString() {
        return "language "+Arrays.toString(concepts.toArray());
    }
    
}
