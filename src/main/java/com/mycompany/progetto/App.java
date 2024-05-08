/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
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
        LocalDate d1=LocalDate.of(2020,9,20);
        Pappagallo p1=new Pappagallo("calopsitta", 1, "m", "albino", d1);
                
        LocalDate d2=LocalDate.of(2020,9,20);
        Pappagallo p2=new Pappagallo("cocorita", 4, "f", "blu", d2);
                
        LocalDate d3=LocalDate.of(2020,9,20);
        Pappagallo p3=new Pappagallo("inseparabile", 5, "m", "cremino", d3);
                
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
        
        /*try {
            np1.rimuoviPappagallo(1);
        } catch (EccezionePosizioneNonValida ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EccezionePosizioneVuota ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.println(np1.toString());
        
        
       // System.out.println(np1.elencoPappagalliSpecie("calopsitta"));
        
        //System.out.println(np1.OrdinaPrezzoCrescente());
        
        /*int numeroVociMenu=5;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        
        
        
        System.out.println("MODIFICA:\n");
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tSpecie";
        vociMenu[2]="2 -->\tEtà";
        vociMenu[3]="3 -->\tGenere";
        vociMenu[4]="4 -->\tMutazione";
        
        menu=new Menu(vociMenu);
        
        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: 
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    
            
            }
        }*/
       /*Scanner tastiera=new Scanner(System.in);
       
        int idPappagallo;
        String nuovaSpecie;
        int nuovaEta;
        String nuovoGenere;
        String nuovaMutazione;
       
       np1.modifica();
       System.out.println(np1.toString());*/
       
       //np1.esportaFileCSV();
       //np1.importaFileCSV();
       
       np1.serializzazione(np1);
       np1.deserializzazione(np1);
    }
    
}

