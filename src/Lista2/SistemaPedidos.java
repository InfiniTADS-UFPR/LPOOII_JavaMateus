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
public class SistemaPedidos {

    ArrayList<Pedido> lista = new ArrayList<Pedido>();
    Scanner scan = new Scanner(System.in);

    public void usa() {
        while (true) {
            try {
                System.out.println("Escolha uma acção: \n1 - Incluir Pedido\n2 - Excluir Pedido por nome do cliente\n3 - Listar Pedidos\n"
                        + "4 - Incluir Item de Pedido em Pedido\n5 - Excluir Item de Pedido em Pedido\n6 - Imprimir lista de Pedidos\n");
                String resposta = scan.next();
                switch (resposta) {
                    case "1":
                        incluirPedido();
                        break;
                    case "2":
                        excluirPedido();
                        break;
                    case "3":
                        listarPedidos();
                        break;
                    case "4":
                        incluirItemPedido();
                        break;
                    case "5":
                        excluirItem();
                        break;
                    case "6":
                        imprimeListaPedido();
                        break;
                    default:
                        System.out.println("Opção invalida.");

                }
            }catch(Exception e){System.out.println(e.getMessage());}
        }
    }

    private void incluirPedido() {
        System.out.println("Nome do cliente:");
        String nome = scan.next();
        System.out.println("Valor maximo:");
        double valor = scan.nextDouble();
        Pedido p = new Pedido(nome, valor);
        lista.add(p);
    }

    private void excluirPedido() {
        System.out.println("Nome do cliente:");
        String nome = scan.next();
        for (Pedido p : lista) {
            if (p.getClient().equalsIgnoreCase(nome)) {
                lista.remove(p);
                System.out.println("Removido.\n");
                return;
            }
        }
        System.out.println("Pedido não encontrado.\n");
    }

    private void listarPedidos() {
        for (Pedido p : lista) {
            System.out.println(p.getClient() + "  " + p.getTotal() + "\n");
        }
    }

    private void excluirItem() {
        System.out.println("Nome do cliente:");
        String nome = scan.next();
        System.out.println("Item da lista:");
        String item = scan.next();
        for (Pedido p : lista) {
            if (p.getClient().equalsIgnoreCase(nome)) {
                p.retiraItem(item);
                return;
            }
        }
        System.out.println("Item não encontrado no Pedido.\n");
    }

    private void imprimeListaPedido() {
        System.out.println("Nome do cliente:");
        String nome = scan.next();
        for (Pedido p : lista) {
            if (p.getClient().equalsIgnoreCase(nome)) {
                System.out.println(p.toString());
                return;
            }
        }
        System.out.println("Lista não encontrada.\n");
    }

    private void incluirItemPedido() {
        System.out.println("Nome do cliente:");
        String nome = scan.next();
        System.out.println("Nome do produto:");
        String id = scan.next();
        System.out.println("Quantidade de produtos:");
        int qtdd = scan.nextInt();
        System.out.println("Preço do produto:");
        double preco = scan.nextDouble();
        ItemDeProduto adiciona = new ItemDeProduto(id, qtdd, preco);
        for (Pedido p : lista) {
            if (p.getClient().equalsIgnoreCase(nome)) {
                p.acrescentaItem(adiciona);
                return;
            }
        }
        System.out.println("Lista não encontrada.\n");
    }

}
