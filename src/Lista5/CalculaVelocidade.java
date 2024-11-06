/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author mateus
 */
public class CalculaVelocidade {
    public static void main(String[] args){
        String tempo="";
        String distancia="";
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o tempo");
        tempo = scan.next();
        System.out.println("Digite a distância");
        distancia = scan.next();
        
        double temp = Double.parseDouble(tempo);
        double dist = Double.parseDouble(distancia);
        
        BigDecimal bdtempo = BigDecimal.valueOf(temp);
        BigDecimal bddist = BigDecimal.valueOf(dist);
        
        BigDecimal velocidade = bddist.divide(bdtempo,3,RoundingMode.CEILING);
        
        System.out.println("Velocidade do automovel é: "+velocidade+"Km/h");
    }
    
}
