package yajco.fle.panels;

public interface PanelAccessor<T> {
    public void setValue(T value);
    public T getValue();
    public void reset();
}
