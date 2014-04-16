/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototyped.model;

/**
 *
 * @author Milan
 */
public class Property {
    private String name;
    private Constraint constraint;

    public Property(String name, Constraint constraint) {
        this.name = name;
        this.constraint = constraint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    @Override
    public String toString() {
        return "Property{" + "name=" + name + ", constraint=" + constraint + '}';
    }
}
