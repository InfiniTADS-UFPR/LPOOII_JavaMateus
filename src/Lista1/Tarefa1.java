/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista1;

import java.util.Scanner;

/**
 *
 * @author mateus
 */
public class Tarefa1 {
    
    static double area;
    
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    double lado1=0, lado2=0;
    System.out.print("Qual a forma? 1 - Retangulo; 2 - Circulo; 3 - Triangulo:");
    int opcao = scan.nextInt();
    switch(opcao){
        case 1:
            lado1 = scan.nextDouble();
            lado2 = scan.nextDouble();                
            System.out.println(Tarefa1.calculaAreaRetangulo(lado1,lado2));
            break;
        case 2: 
            lado1 = scan.nextDouble();
            System.out.println(Tarefa1.calculaAreaCircunferencia(lado1));
            break;
        case 3: 
            lado1 = scan.nextDouble();
            lado2 = scan.nextDouble();   
            System.out.println(Tarefa1.calcularAreaTriangulo(lado1, lado2));
            break;
        }
    }
    
    
    public static double calculaAreaRetangulo(double lado1, double lado2){
        if (lado1<0 || lado2<0) throw new RuntimeException("Lados não podem ser negativos.");
        area = lado1*lado2;
        return area;
    }
    
    public static double calculaAreaCircunferencia(double raio){
        if (raio<0) throw new RuntimeException("Lados não podem ser negativos.");
        area = raio*raio*3.14;
        return area;
    }
    
    public static double calcularAreaTriangulo(double base, double altura){
        if (base<0 || altura<0) throw new RuntimeException("Lados não podem ser negativos.");
        area = (base*altura)/2;
        return area;
    }
    
}
