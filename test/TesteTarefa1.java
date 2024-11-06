/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Lista1.Tarefa1;
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
public class TesteTarefa1 {
    
    public TesteTarefa1() {
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
        assertEquals(6,Tarefa1.calculaAreaRetangulo(2,3),0.0);
        assertEquals(3.14,Tarefa1.calculaAreaCircunferencia(1),0.0);
        assertEquals(2,Tarefa1.calcularAreaTriangulo(2, 2),0.0);             
    }
    
    @Test
    public void Teste2(){
        assertEquals(9,Tarefa1.calculaAreaRetangulo(3,3),0.0);
        assertEquals(12.56,Tarefa1.calculaAreaCircunferencia(2),0.0);
        assertEquals(8,Tarefa1.calcularAreaTriangulo(4,4),0.0);
    }
    
    
}
