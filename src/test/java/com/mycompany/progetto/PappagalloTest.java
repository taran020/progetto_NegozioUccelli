/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author taran
 */
public class PappagalloTest
{
    
    public PappagalloTest() {
    }
    
    Pappagallo p;

    @BeforeEach
    void setUp() 
    {
        p.resetNextId();
        p = new Pappagallo("s1", 2, "m", "m1", LocalDate.of(2024, 1, 1));
    }

    @AfterEach
    void tearDown() throws Exception 
    {
        p = null;
    }

    /**
     * Test of getSpecie,setSpecie method, of class Pappagallo.
     */
    @Test
    public void testGetSetSpecie() 
    {
        p.setSpecie("s2");
        assertEquals("s2", p.getSpecie());
    }

    
    /**
     * Test of getEta,setEta method, of class Pappagallo.
     */
    @Test
    public void testGetSetEta() 
    {
        p.setEta(5);
        assertEquals(5, p.getEta());

    }
    
    @Test
    public void testSetEtaNegativa() 
    {
        p.setEta(-5);
        assertEquals(0, p.getEta());

    }

    /**
     * Test of getGenere method, of class Pappagallo.
     */
    @Test
    public void testGetSetGenere()
    {
        p.setGenere("f");
        assertEquals("F",p.getGenere());
    }

    /**
     * Test of getMutazione method, of class Pappagallo.
     */
    @Test
    public void testGetSetMutazione() 
    {
        p.setMutazione("m2");
        assertEquals("m2", p.getMutazione());
    }

    /**
     * Test of getIdPappagallo method, of class Pappagallo.
     */
    @Test
    public void testGetIdPappagallo() 
    {
        assertEquals(1, p.getIdPappagallo());
    }

    /**
     * Test of setDataNascita method, of class Pappagallo.
     */
    @Test
    public void testSetGetDataNascita() 
    {
        p.setDataNascita(LocalDate.of(2023, 5, 15));
        LocalDate nuovaDataNascita = LocalDate.of(2023, 10, 25);

        p.setDataNascita(nuovaDataNascita);
        
        assertEquals(nuovaDataNascita, p.getDataNascita());
        
    }
    
    
    @Test
    public void testPrezzo()
    {
        p=new Pappagallo("calopsitta", 5, "f", "cinnamon", LocalDate.of(2022, 5, 15));
        assertEquals(60.0, p.prezzo());
    }
    
    /**
     * Test of equals method, of class Pappagallo.
     */
    @Test
    public void testEquals()
    {
        p=new Pappagallo("s1", 1, "f", "m1", LocalDate.of(2023, 5, 15));
        Pappagallo p2=new Pappagallo("s1", 1, "f", "m1", LocalDate.of(2023, 5, 15));
        
        assertEquals(p2, p);
    }

    /**
     * Test of toString method, of class Pappagallo.
     */
    @Test
    public void testToString() 
    {
        p=new Pappagallo("s1", 1, "f", "m1", LocalDate.of(2023, 5, 15));
        
        assertEquals("2;s1;1;F;m1;2023-05-15;0.0€", p.toString());

    }
    
}
