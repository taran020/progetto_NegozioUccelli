/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taran
 */
public class App 
{

    public static void main(String[] args) 
    {
        Date d1=new Date(2024, 4, 1);
        Pappagallo p1=new Pappagallo("calopsitta", 5, "m", "albino", d1);
                
        Date d2=new Date(2023, 11, 28);
        Pappagallo p2=new Pappagallo("cocorita", 2.5, "f", "blu", d2);
                
        Date d3=new Date(2022, 7, 15);
        Pappagallo p3=new Pappagallo("inseparabile", 1.5, "m", "cremino", d3);
                
        NegozioPappagalli np1=new NegozioPappagalli();
        try 
        {
            np1.aggiungiPappagallo(p1, 0);
            np1.aggiungiPappagallo(p2, 1);
            np1.aggiungiPappagallo(p3, 2);
        } catch (EccezionePosizioneNonValida ex) 
        {
            
        } catch (EccezionePosizioneOccupata ex)
        {
            
        }
        
        try {
            np1.rimuoviPappagallo(1);
        } catch (EccezionePosizioneNonValida ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EccezionePosizioneVuota ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(np1.toString());
    }
}
