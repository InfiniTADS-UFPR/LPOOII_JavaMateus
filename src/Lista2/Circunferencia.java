/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

/**
 *
 * @author mateus
 */
public class Circunferencia {
    
    private double raio;
    
    public Circunferencia(double raio){
        if (raio<0) throw new RuntimeException("Raio não pode ser negativo.");
        this.raio = raio;
    }
    
    public double area(){
        return this.raio*this.raio*3.14;
    }
    
}
