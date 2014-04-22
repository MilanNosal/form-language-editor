package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;
import java.util.List;
import yajco.annotation.Exclude;
import yajco.annotation.Range;
import yajco.annotation.printer.NewLine;

public class Model {
    private final List<Entity> entities;

    private final List<Reference> references;

    public Model(@Range(minOccurs = 1) List<Entity> entities, @NewLine List<Reference> references) {
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

    public List<Reference> getReferences() {
        return references;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities.toArray()) + " " + Arrays.toString(references.toArray());
    }
}
