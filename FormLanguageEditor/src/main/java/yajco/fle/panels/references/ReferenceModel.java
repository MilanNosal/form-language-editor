package yajco.fle.panels.references;

import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public abstract class ReferenceModel<T> implements ComboBoxModel<String>, Observer {

    private String selectedItem;
    private final Set<ListDataListener> listeners = new HashSet<>();
    private final Class<T> concept;
    private List<Object> values;

    public ReferenceModel(Class<T> concept) {
        this.concept = concept;
        this.values = ConceptInstanceLookup.getInstance().getInstancesOfConcept(concept);
        ConceptInstanceLookup.getInstance().addObserver(this);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
    public int getIndexOf(T value) {
        return values.indexOf(value);
    }
    
    public T getValueAt(int index) {
        return (T) values.get(index);
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public abstract String getElementAt(int index);

    @Override
    public void addListDataListener(ListDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListDataListener(ListDataListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.values = ConceptInstanceLookup.getInstance().getInstancesOfConcept(concept);
        for (ListDataListener listener : listeners) {
            listener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, this.getSize()));
        }
    }

}
