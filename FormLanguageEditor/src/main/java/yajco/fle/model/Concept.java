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
    
    private List<Property> properties = new ArrayList<>();
    
    private String languageModelClassName;
    
    public List<Property> getProperties() {
        return properties;
    }

    public String getLanguageModelClassName() {
        return languageModelClassName;
    }
    
}
