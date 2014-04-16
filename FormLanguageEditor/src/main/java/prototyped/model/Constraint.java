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
public class Constraint {
    private int min;
    private int max;

    public Constraint(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Constraint{" + "min=" + min + ", max=" + max + '}';
    }
    
}
