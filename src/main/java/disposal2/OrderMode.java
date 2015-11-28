/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposal2;

/**
 *
 * @author Martin
 */
public enum OrderMode {
    NORMAL(5),
    FAST(4);
    
    private final int id;
    OrderMode(int id) { this.id = id; }
    public int getValue() { return id; }
}
