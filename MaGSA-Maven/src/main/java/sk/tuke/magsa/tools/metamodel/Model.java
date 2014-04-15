package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;
import sk.tuke.magsa.tools.metamodel.ui.UI;
import yajco.annotation.Exclude;
import yajco.annotation.Range;

public class Model {
    private final Entity[] entities;

    private UI ui;

    private final Reference[] references;

    public Model(@Range(minOccurs = 1) Entity[] entities, Reference[] references) {
        this.entities = entities;
        this.references = references;
    }

    @Exclude
    public Model(Entity[] entities) {
        this.entities = entities;
        this.references = null;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public Entity findEntity(String name) {
        for (Entity entity : entities) {
            if (name.equals(entity.getName())) {
                return entity;
            }
        }
        return null;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public Reference[] getReferences() {
        return references;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities) + " " + Arrays.toString(references) + " " + ui;
    }
}
