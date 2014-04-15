package yajco.fle.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author DeeL
 */
public class BaseSourceElement<T> {
    protected T sourceElement;

    public T getSourceElement() {
        return sourceElement;
    }

    public void setSourceElement(T sourceElement) {
        this.sourceElement = sourceElement;
    }
    
}
