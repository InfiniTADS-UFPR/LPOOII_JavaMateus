/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista4;

/**
 *
 * @author mateus
 */
public class SomaAreas<T extends Superficie> {
    
    public double calculaArea(T array[]){
        double valor =0;
        for(T elemento:array){
            valor += elemento.area();
        }
        return valor;
    }
    
}
