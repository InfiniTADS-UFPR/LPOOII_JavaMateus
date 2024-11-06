/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista4;

/**
 *
 * @author mateus
 */
public class Circunferencia implements Superficie {
    
    public double raio;
    
    public Circunferencia(double raio){
        this.raio = raio;
    }

    @Override
    public double area() {
        return (this.raio*this.raio*Math.PI);
    }
    
}
