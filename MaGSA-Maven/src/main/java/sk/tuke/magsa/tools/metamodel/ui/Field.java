package sk.tuke.magsa.tools.metamodel.ui;

//TASK 6
public class Field extends Component {
    @Override
    public String toString() {
        return "field " + getPropertyName();
    }
}
