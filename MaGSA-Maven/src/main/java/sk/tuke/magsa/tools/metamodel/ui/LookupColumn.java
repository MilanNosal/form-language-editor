package sk.tuke.magsa.tools.metamodel.ui;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import sk.tuke.magsa.tools.metamodel.Entity;

//Property sa tu pouzije na vyber vlastnosti na zobrazenie z entity
public class LookupColumn extends Column {
    private String entityName;

    private Entity entity;

    @XmlAttribute(name = "entity", required = true)
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @XmlTransient
    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
