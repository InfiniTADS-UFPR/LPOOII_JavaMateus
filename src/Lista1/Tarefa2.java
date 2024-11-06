package Lista1;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateus
 */
public class Tarefa2 {

    
    static double valorHora, salarioBruto, salarioLiquido;
    static int horas,desconto;

    public static double calcilarSalarioLiquido() {
        salarioLiquido = salarioBruto - salarioBruto*desconto/100;
        return salarioLiquido;
    }

    public static String imprimirRelatorio() {
        String formatBruto = String.format("%.2f", salarioBruto);
        String formatLiquido = String.format("%.2f",salarioLiquido);
        String formatHora = String.format("%.2f", valorHora);
        return "Extrato de Relatorio\n"
                + "Valor Hora: R$ "+formatHora+"\n"
                + "Horas Trabalhadas: "+horas+" horas\n"
                + "Salario Bruto: R$ "+formatBruto+"\n"
                + "Salario Liquido: R$ "+formatLiquido;
    }

    public Tarefa2(double d, int i, int i0) {
        Tarefa2.valorHora = d;
        Tarefa2.horas = i;
        Tarefa2.desconto = i0;
    }
    
    public static double calcularSalarioBruto() {
        salarioBruto = valorHora * horas;
        return salarioBruto;
    }
    
    
}
