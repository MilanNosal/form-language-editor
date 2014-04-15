package yajco.fle.panels;

public interface PanelAccessor<T> {
    public void setValue(T value);
    public T getValue();
    public void reset();
    public void setLabel(String label);
    public void setDescription(String description);
}
