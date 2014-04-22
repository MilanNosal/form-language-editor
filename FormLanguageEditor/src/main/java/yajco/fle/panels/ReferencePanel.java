package yajco.fle.panels;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import yajco.fle.panels.references.ConceptInstanceLookup;

/** @author Michaela Bačíková */
public class ReferencePanel <T> extends AbstractAccessiblePanel<T> {
    
    private final Class<T> concept;

    // TODO: toto by malo byt dynamicke, nie? ci budem zakazdym ked sa ma zobrazit reference panel tvorit novy objekt?
    public ReferencePanel(Class<T> concept) {
        this.concept = concept;
        initComponents();
        ReferenceModel r = new ReferenceModel();
        ConceptInstanceLookup.getInstance().addObserver(r);
        valuesCombobox.setModel(r);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valuesCombobox = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCombobox, 0, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox valuesCombobox;
    // End of variables declaration//GEN-END:variables
       
    @Override
    public void setValue(T value) {
        valuesCombobox.setSelectedItem(value);
    }

    @Override
    public T getValue() {
        return (T) valuesCombobox.getSelectedItem();
    }

    @Override
    public void reset() {
        valuesCombobox.setEnabled(valuesCombobox.getModel().getSize() > 0);
        if(valuesCombobox.isEnabled()) {
            valuesCombobox.setSelectedIndex(0);
        } 
    }
    
    private class ReferenceModel implements ComboBoxModel<T>, Observer {
        
        private T selectedItem;
        private final Set<ListDataListener> listeners = new HashSet<>();

        public ReferenceModel() {
        }

        @Override
        public void setSelectedItem(Object anItem) {
            selectedItem = (T) anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selectedItem;
        }

        @Override
        public int getSize() {
            return ConceptInstanceLookup.getInstance().getInstancesOfConcept(concept).size();
        }

        @Override
        public T getElementAt(int index) {
            return (T) ConceptInstanceLookup.getInstance().getInstancesOfConcept(concept).get(index);
        }

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
            for(ListDataListener listener : listeners) {
                listener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, this.getSize()));
            }
        }
        
    }
}
