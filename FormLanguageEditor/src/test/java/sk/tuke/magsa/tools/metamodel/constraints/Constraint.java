package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

public abstract class Constraint {
    //TODO: Rozsitit tak aby som vedel testovat ci to podporuje dany typ
    //Mozno by to bolo realizovatelne aj cez rozhrania a ich implementaciu IntegerConstraint, RealConstraint, StringConstraint
//    public abstract Set<Type> getSupportedTypes();
    public abstract boolean supportsType(Type type);
}
