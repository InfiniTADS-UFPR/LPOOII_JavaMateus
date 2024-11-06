/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista4;

/**
 *
 * @author mateus
 */
public class Quadrado implements Superficie {
    public double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }
    
    @Override
    public double area() {
        return this.lado*this.lado;
    }
    
    
    
}
