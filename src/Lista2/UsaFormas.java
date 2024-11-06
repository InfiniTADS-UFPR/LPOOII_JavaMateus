/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mateus
 */
public class UsaFormas {
    
    public static void main(String[] args){
        ArrayList<Double> formas = new ArrayList<Double>();
        int vezes = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos números deseja digitar?");
        vezes = scan.nextInt();
        
        for (int i=0;i<vezes;i++){
            System.out.println("Qual a forma? 1-Circulo 2-Triangulo 3-Retangulo s-Sair:");
            String forma = scan.next();
            if (forma.equalsIgnoreCase("s"))
                break;
            switch (forma){
                case "1":
                    System.out.print("Qual o raio da circunfência?");
                    double raio = scan.nextDouble();
                    Circunferencia c = new Circunferencia(raio);
                    formas.add(c.area());
                    break;
                case "2":
                    System.out.print("Qual a base do triangulo?");
                    double base = scan.nextDouble();
                    System.out.print("Qual a altura do triangulo?");
                    double altura = scan.nextDouble();
                    Triangulo t = new Triangulo(base,altura);
                    formas.add(t.area());
                    break;
                case "3":
                    System.out.println("Qual o lado 1 do retângulo?");
                    double lado1 = scan.nextDouble();
                    System.out.println("Qual o lado 2 do retângulo?");
                    double lado2 = scan.nextDouble();
                    Retangulo r = new Retangulo(lado1, lado2);
                    formas.add(r.area());
                    break;
                default:
                    System.out.println("Input invalido, tente novamente.");
                    i--;
                    break;
            }
        }
        
        System.out.println("Imprimindo formas:");
        for (double forma : formas){
            System.out.println(forma+"\n");
        }
    }
    
}
