/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.FileException;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author taran
 */
public class NegozioPappagalliTest 
{
    
    public NegozioPappagalliTest(){
    }
    
    Pappagallo p1=new Pappagallo("s1", 8, "g1", "m1", LocalDate.of(2023,11,20));
    Pappagallo p2=new Pappagallo("s2", 6, "g2", "m2", LocalDate.of(2022,5,15));
    Pappagallo p3=new Pappagallo("s3", 7, "g3", "m3", LocalDate.of(2021,8,5));

    NegozioPappagalli np1;
    
    @BeforeEach
    public void istanzioNegozio()
    {
        Pappagallo.resetNextId();
        np1=new NegozioPappagalli();
    }

    /**
     * Test of aggiungiPappagallo method, of class NegozioPappagalli.
     */
    @Test
    public void testSetGetPappagalloPosValida() throws Exception
    {
        np1.aggiungiPappagallo(p1, 0);
        assertEquals(p1, np1.getPappagallo(0));
    }
    
    @Test
    public void testSetPappagalloPosNegativa()
    {
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.aggiungiPappagallo(p1, -1));
    }
    
    @Test
    public void testSetPappagalloPosMaggioreDelMassimo()
    {
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.aggiungiPappagallo(p1, 12));
    }
    
    @Test
    public void testSetPappagalloPosOccupata() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
       np1.aggiungiPappagallo(p1, 4);
       EccezionePosizioneOccupata eccezione = assertThrows(EccezionePosizioneOccupata.class, () ->
            np1.aggiungiPappagallo(p2, 4));
    }
    
    @Test
    public void testGetPappagalloPosNegativa() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
       np1.aggiungiPappagallo(p1, 4);
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.getPappagallo(-1));
    }
    
    @Test
    public void testGetPappagalloPosMaggioreDelMassimo() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
       np1.aggiungiPappagallo(p1, 4);
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.getPappagallo(12));
    }
    
    @Test
    public void testGetPappagalloPosVuota() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
       np1.aggiungiPappagallo(p1, 4);
       EccezionePosizioneVuota eccezione = assertThrows(EccezionePosizioneVuota.class, () ->
            np1.getPappagallo(0));
    }

    /**
     * Test of rimuoviPappagallo method, of class NegozioPappagalli.
     */
    @Test
    public void testRimuoviPappagalloCorrettamente() throws Exception 
    {
        np1.aggiungiPappagallo(p1, 0);
        np1.rimuoviPappagallo(0);
        
        assertThrows(EccezionePosizioneVuota.class, () -> np1.getPappagallo(0));
    }
    
    
    @Test
    public void testRimuoviPappagalloPosNegativa() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida 
    {
       np1.aggiungiPappagallo(p1, 0);
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.rimuoviPappagallo(-1));
    }
    
    @Test
    public void testRimuoviPappagalloPosMaggioreDelMassimo() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida 
    {
       np1.aggiungiPappagallo(p1, 0);
       EccezionePosizioneNonValida eccezione = assertThrows(EccezionePosizioneNonValida.class, () ->
            np1.rimuoviPappagallo(12));
    }
    
    @Test
    public void testRimuoviPappagalloPosVuota() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida 
    {
       
       EccezionePosizioneVuota eccezione = assertThrows(EccezionePosizioneVuota.class, () ->
            np1.rimuoviPappagallo(0));
    }

    /**
     * Test of elencoPappagalliSpecie method, of class NegozioPappagalli.
     */
    @Test
    public void testElencoPappagalliSpecie() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        np1.aggiungiPappagallo(p1, 0);
        np1.aggiungiPappagallo(p2, 1);

        Pappagallo[] specie = np1.elencoPappagalliSpecie("s1");
        assertEquals(1, specie.length);
        assertEquals(p1, specie[0]);

    }
    
    /**
     * Test of ordinaPrezzoCrescente method, of class NegozioPappagalli.
     */
    @Test
    public void testOrdinaPrezzoCrescente() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        np1.aggiungiPappagallo(p1, 0);
        np1.aggiungiPappagallo(p2, 1);
        np1.aggiungiPappagallo(p3, 2);

        Pappagallo[] pappagalliOrdinati = np1.ordinaPrezzoCrescente();

        assertTrue(pappagalliOrdinati[0].prezzo() <= pappagalliOrdinati[1].prezzo());
        assertTrue(pappagalliOrdinati[1].prezzo() <= pappagalliOrdinati[2].prezzo());
    }
    
}
