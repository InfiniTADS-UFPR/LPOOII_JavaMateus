/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

/**
 *
 * @author mateus
 */
public class ItemDeProduto {
    
    private String nome;
    private int quantidade;
    private double preco;
    
    public ItemDeProduto(String nome,int quantidade,double preco){
        if (preco<0 || quantidade <1 || nome == "") throw new RuntimeException("Parametros não foram inicializados corretamente");
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
