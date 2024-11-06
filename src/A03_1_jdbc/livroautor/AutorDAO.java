package A03_1_jdbc.livroautor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutorDAO {

    private final String stmtInserir = "INSERT INTO autor(nome) VALUES(?)";
    private final String stmtConsultar = "SELECT * FROM autor WHERE id = ?";
    private final String stmtListar = "SELECT * FROM autor";
    private final String stmtLivroAutor = "INSERT INTO livro_autor (id_livro,id_autor) VALUES (?,?)";

    public void inserirAutor(Autor autor) {
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, autor.getNome());
            stmt.executeUpdate();
            autor.setId(lerIdAutor(stmt));
            inserirEmConjunto(autor.getId());
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
     }
    
    private int lerIdAutor(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public Autor consultarAutor(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autorLido;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtConsultar);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                autorLido = new Autor(rs.getString("nome"));
                autorLido.setId(rs.getInt("id"));
                return autorLido;
            }else{
                throw new RuntimeException("Não existe autor com este id. Id="+id);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }

    }

    public List<Autor> listarAutores() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Autor> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while(rs.next()){
                Autor autor = new Autor(rs.getString("nome"));
                autor.setId(rs.getInt("id"));
                lista.add(autor);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar uma lista de autores. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};               
        }

    }
    
    public void inserirAutorLivro(int idAutor,int idLivro){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtLivroAutor);
            stmt.setInt(1, idLivro);
            stmt.setInt(2, idAutor);
            stmt.executeUpdate();
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor/livro no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }

    private void inserirEmConjunto(int id) {
        LivroDAO livro = new LivroDAO();
        while(true){
            System.out.println("Escolha uma das opções:\n1. Adicionar um livro a um autor\n2. Listar os livros\n3. Sair");
            Scanner scan = new Scanner(System.in);
            int escolha = scan.nextInt();
            int livroId = 0;
            switch (escolha){
                case 1:
                    System.out.println("Digite o id do livro:");
                    livroId = scan.nextInt();
                    inserirAutorLivro(id,livroId);
                    break;
                case 2:
                    List<Livro> livros = livro.listarLivroComAutores();
                    for (Livro pagina : livros){
                        System.out.println("Id. "+pagina.getId()+" | Nome: "+pagina.getTitulo());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    List<Livro> listaDeLivros(int id, Connection con) {
        List<Livro> listagem = new ArrayList<>();
        String oqfaz = "SELECT nome FROM livro INNER JOIN livro_autor ON livro.id = livro_autor.id_livro WHERE id_autor = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement(oqfaz);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                Livro pagina = new Livro(rs.getString("nome"),new ArrayList<Autor>());
                listagem.add(pagina);
            }
            return listagem;
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao pesquisar no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());}
            try{stmt.close();}catch(Exception ex1){System.out.println("Erro ao fechar stmt. Ex="+ex1.getMessage());}
        }   
    }

}
