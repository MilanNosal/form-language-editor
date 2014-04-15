package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

//Vsetko by malo byt odvoditelne z Table
//Je to entity aj id stlpce/ teoreticky by tu mohlo byt property pri zobrazneni vypisovania
//Property sa pouzije na vyber pri predbeznom zobrazeni???
public class LookupField extends Field {
    private Table table;

    @XmlAttribute(name = "table", required = true)
    @XmlIDREF
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
