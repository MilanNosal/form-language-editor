package yajco.fle.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DeeL
 */
public class Concept {
    private Set<Concept> directSubtypes = new HashSet<Concept>();
    
    private List<Property> properties = new ArrayList<>();
    
    private String languageModelClassName;

    public Set<Concept> getDirectSubtypes() {
        return directSubtypes;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public String getLanguageModelClassName() {
        return languageModelClassName;
    }
    
}
