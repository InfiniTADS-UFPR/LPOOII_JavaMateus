/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

/**
 *
 * @author mateus
 */
public class Triangulo {
    
    private double base, altura;
    
    public Triangulo(double base, double altura){
        if (base<0 || altura<0) throw new RuntimeException("Base ou altura não podem ser negativos.");
        this.base = base;
        this.altura = altura;
    }
    
    public double area(){
        return (this.base*this.altura/2);
    }
}
