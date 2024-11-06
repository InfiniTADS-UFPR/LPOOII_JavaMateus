/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Lista2.Circunferencia;
import Lista2.Retangulo;
import Lista2.Triangulo;
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
public class TesteTarefa3 {
    
    public TesteTarefa3() {
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
    public void teste1() {
        Circunferencia c = new Circunferencia(5);
        Retangulo r = new Retangulo(2,3);
        Triangulo t = new Triangulo(6,1);
        assertEquals(78.5,c.area(),0.0);
        assertEquals(6,r.area(),0.0);
        assertEquals(10,r.perimetro(),0.0);
        assertEquals(3,t.area(),0.0);
    }
    @Test
    public void teste2() {
        Circunferencia c = new Circunferencia(2.4);
        Retangulo r = new Retangulo(2.1,3);
        Triangulo t = new Triangulo(6,1.2);
        assertEquals(18.0864,c.area(),0.0);
        assertEquals(6.3,r.area(),0.1);
        assertEquals(10.2,r.perimetro(),0.0);
        assertEquals(3.59,t.area(),0.1);
    }
 }
