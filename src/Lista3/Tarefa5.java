/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista3;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mateus
 */
public class Tarefa5 {
    public static void main(String[] args) throws SQLException{
    ContaDao conta = new ContaDao();
     
    Contato contato = new Contato();
     
    contato.setNome("Andre");
    
    conta.insere(contato);
    
    List<Contato> lista = conta.lista();

     for (Contato cont:lista){
        System.out.println("Nome:"+cont.getNome()+"\tID:"+cont.getId()+"\n");
    }
        System.out.println("\n");
    
    Contato contato1 = new Contato();
    contato1.setNome("Gabriel");
    contato1.setId(contato.getId());
    
    conta.altera(contato1);
    
    lista = conta.lista();
    
    for (Contato cont:lista){
        System.out.println("Nome:"+cont.getNome()+"\tID:"+cont.getId()+"\n");
    }
    System.out.println("\n");

   
    
    conta.remove(contato1);
    
    lista = conta.lista();
    
    
    for (Contato cont:lista){
        System.out.println("Nome:"+cont.getNome()+"\tID:"+cont.getId()+"\n");
    }
    System.out.println("\n");
    
    }
}
