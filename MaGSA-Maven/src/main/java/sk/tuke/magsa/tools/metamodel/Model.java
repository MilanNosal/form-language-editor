package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;
import java.util.List;
import sk.tuke.magsa.tools.metamodel.ui.UI;
import yajco.annotation.Exclude;
import yajco.annotation.Range;

public class Model {
    private final List<Entity> entities;

    private UI ui;

    private final List<Reference> references;

    public Model(@Range(minOccurs = 1) List<Entity> entities, List<Reference> references) {
        this.entities = entities;
        this.references = references;
    }

    @Exclude
    public Model(List<Entity> entities) {
        this.entities = entities;
        this.references = null;
    }

    public List<Entity> getEntities() {
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

    public List<Reference> getReferences() {
        return references;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities.toArray()) + " " + Arrays.toString(references.toArray()) + " " + ui;
    }
}
