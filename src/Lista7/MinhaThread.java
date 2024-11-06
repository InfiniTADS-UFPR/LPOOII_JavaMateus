/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class MinhaThread extends Thread {
    private int numero;
    
    public MinhaThread(int valor){
        this.numero = valor;
    }
    
    public void run(){
        for (int i=0;i<this.numero;i++){
            System.out.println(getName()+" - "+i);
            try {
                MinhaThread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
