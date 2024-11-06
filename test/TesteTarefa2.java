/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Lista1.Tarefa2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateus
 */
public class TesteTarefa2 {
    
    public TesteTarefa2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void Teste1(){
        String relatorio = "Extrato de Relatorio\n"
                + "Valor Hora: R$ 3,15\n"
                + "Horas Trabalhadas: 100 horas\n"
                + "Salario Bruto: R$ 315,00\n"
                + "Salario Liquido: R$ 236,25";
        Tarefa2 trabalhador = new Tarefa2(3.15,100,25);
        assertEquals(315,Tarefa2.calcularSalarioBruto(),0.0);
        assertEquals(236.25,Tarefa2.calcilarSalarioLiquido(),0.0);
        String resposta = Tarefa2.imprimirRelatorio();
        assertEquals(relatorio,resposta);
    }
    
    @Test
    public void Teste2(){
        String relatorio = "Extrato de Relatorio\n"
                + "Valor Hora: R$ 2,25\n"
                + "Horas Trabalhadas: 220 horas\n"
                + "Salario Bruto: R$ 495,00\n"
                + "Salario Liquido: R$ 435,60";
        Tarefa2 trabalhador = new Tarefa2(2.25,220,12);
        assertEquals(495,Tarefa2.calcularSalarioBruto(),0.0);
        assertEquals(435.60,Tarefa2.calcilarSalarioLiquido(),0.0);
        String resposta = Tarefa2.imprimirRelatorio();
        assertEquals(relatorio,resposta);
    }
    // public void hello() {}
}
