/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateus
 */
public class ContaDao {
    
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Java";
        String user = "root";
        String pwd = "Pokem@00";
        return (Connection) DriverManager.getConnection(
                url,user,pwd);   
    }

    
    public void altera(Contato contato) throws SQLException{
        String alter = "UPDATE Contato SET nome = ? WHERE id = ?";
        try (Connection connection = ContaDao.getConnection();
             PreparedStatement alterContato = connection.prepareStatement(alter, Statement.RETURN_GENERATED_KEYS);
        ){
            alterContato.setString(1, contato.getNome());
            alterContato.setString(2, contato.getId().toString());
            alterContato.execute();
            
        }
    }
    
    public void remove (Contato contato) throws SQLException{
        String remover = "DELETE FROM Contato WHERE id = ?";
        try (Connection connection = ContaDao.getConnection();
            PreparedStatement removeContato = connection.prepareStatement(remover);
        ){
            removeContato.setString(1,contato.getId().toString());
            removeContato.execute();
        }
    }
    
    public List<Contato> lista() throws SQLException{
        String listagem = "SELECT nome, id FROM Contato";
        List<Contato> contatos = new ArrayList();
        try (Connection connection = ContaDao.getConnection();
             PreparedStatement listaContato = connection.prepareStatement(listagem);
             ResultSet rs = listaContato.executeQuery();   
        ){
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                contatos.add(new Contato(nome,id));
            }
        }        
        return contatos;
    }
    
    public void insere (Contato contato) throws SQLException{
        String insrt = "INSERT INTO Contato (nome) VALUES (?)";
        try (Connection connection = ContaDao.getConnection();
            PreparedStatement addContato = connection.prepareStatement(insrt, Statement.RETURN_GENERATED_KEYS);
        ){
            addContato.setString(1,contato.getNome());
            addContato.execute();
            ResultSet rs = addContato.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            contato.setId(i);
        } 
    }
    
}
