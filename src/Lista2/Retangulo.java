/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

/**
 *
 * @author mateus
 */
public class Retangulo {
    
    private double lado1, lado2;
    
    public Retangulo(double lado1, double lado2){
        if (lado1<0 || lado2<0) throw new RuntimeException("Nehum dos lados não podem ser negativos.");
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    public double area(){
        return this.lado1*this.lado2;
    }
    
    public double perimetro(){
        return this.lado1*2+this.lado2*2;
    }
    
}
