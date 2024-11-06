/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class Pedido {
    private String client;
    private double total, atual=0;
    ArrayList<ItemDeProduto> prods = new ArrayList<ItemDeProduto>();
    
    public Pedido(String client, double total){
        this.client = client;
        this.total = total;
    }
    
    String getClient(){
        return this.client;
    }
    
    ArrayList<ItemDeProduto> getItems(){
        return prods;
    }
    
    void acrescentaItem(ItemDeProduto adiciona){
        if (adiciona == NULL) throw new RuntimeException("Produto não pode ser Nulo!!");
        if (this.total < (this.atual+adiciona.getPreco())) throw new RuntimeException("Item de pedido não incluído. Valor do pedido Excedido.");
        if (this.total == 0) throw new RuntimeException("Cliente não tem nenhum crédito.");
        for (ItemDeProduto produto : prods){
            if (adiciona.getNome().equalsIgnoreCase(produto.getNome())){
                produto.setQuantidade(produto.getQuantidade() + adiciona.getQuantidade());
                return;
            }
        }
        prods.add(adiciona);
        atual += adiciona.getPreco()*adiciona.getQuantidade();
    }

    void retiraItem (String nome){
        for (ItemDeProduto produto : prods){
            if (nome.equalsIgnoreCase(produto.getNome())){
                prods.remove(produto);
                atual -= produto.getPreco()*produto.getQuantidade();
                return;
            }
        }
        throw new RuntimeException("Item não encontrado no pedido.");
    }
    
    double getTotal(){
        return this.atual;
    }
    
    @Override
    public String toString(){
        String formatAtual = String.format("%.2f", this.atual);
        String saida = "-------------------------------\nNome do Cliente: "+this.client+"\n"
                + "Total do Pedido: R$"+formatAtual+"\n"
                + "Item\t\t\t|Preço\n";
        for (ItemDeProduto item : prods){
            String formaPreco = String.format("%.2f",item.getPreco());
            saida += item.getNome()+"\t\t\t|R$"+formaPreco+"\n";
        }
        saida +="-------------------------------\n";
        return saida;
    }
}
