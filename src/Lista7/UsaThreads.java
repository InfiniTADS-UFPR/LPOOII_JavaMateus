/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista7;

/**
 *
 * @author mateus
 */
public class UsaThreads {
    
    public static void main(String[] Args){
        MinhaThread t1 = new MinhaThread(10);
        MinhaThread t2 = new MinhaThread(20);
        
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        
        } catch (Exception e){
            System.out.println("erro");
        }
    }
    
}
