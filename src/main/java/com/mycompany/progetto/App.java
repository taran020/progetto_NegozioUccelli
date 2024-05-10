/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
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
         
        //System.out.println(np1.toString());
     //  np1.esportaFileCSV();
       //np1.importaFileCSV();
      
        np1.serializzazione(np1);
        
        //np1.deserializzazione(np1);
         //System.out.println(np1.toString());
            
       /* int numeroVociMenu=11;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scanner tastiera=new Scanner(System.in);

        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i pappagalli";
        vociMenu[2]="2 -->\tAggiungi pappagallo";
        vociMenu[3]="3 -->\tCerca pappagallo";
        vociMenu[4]="4 -->\tElimina pappagallo";
        vociMenu[5]="5 -->\tMostra pappagalli di una specifica specie";
        vociMenu[6]="6 -->\tMostra pappagalli presenti ordinati per prezzo crescente";
        vociMenu[7]="7 -->\tEsporta pappagalli in formato CSV";
        vociMenu[8]="8 -->\tImporta pappagalli dal file CSV";
        vociMenu[9]="9 -->\tSalva dati pappagallo";
        vociMenu[10]="10 -->\tCarica dati pappagallo";
        menu=new Menu(vociMenu);

        String specie,mutazione,genere;
        int eta;
        int g,m,a;
        int posizione;
        LocalDate dataNascita = null;
        Pappagallo p = null;

        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: //Esci
                    System.out.println("Arrivederci");
                    break;
                case 1://Visualizza tutti
                    System.out.println(np1.toString());
                    break;
                case 2:
                    System.out.println("Specie --> ");
                    specie=tastiera.nextLine();
                    System.out.println("Età --> ");
                    eta=tastiera.nextInt();

                    tastiera.nextLine();

                    System.out.println("Genere --> ");
                    genere=tastiera.nextLine();
                    System.out.println("Mutazione --> ");
                    mutazione=tastiera.nextLine();
                    
                    boolean inputValido = false;

                    while (!inputValido)
                    {
                        try
                        {
                            System.out.println("Data di nascita: ");
                            System.out.print("Giorno --> ");
                            g = tastiera.nextInt();
                            System.out.print("Mese --> ");
                            m = tastiera.nextInt();
                            System.out.print("Anno --> ");
                            a = tastiera.nextInt();

                            // Controllo se la data è valida
                            dataNascita = LocalDate.of(a, m, g);
                            inputValido = true;
                        }
                        catch (DateTimeException e)
                        {
                            System.out.println("La data inserita non è valida. Riprova.");
                            tastiera.nextLine(); // Pulisce il buffer di input
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Inserire un valore numerico.");
                            tastiera.nextLine();
                        }
                    }

                    System.out.println("Posizione --> ");
                    posizione=tastiera.nextInt();

                    try
                    {
                        p=new Pappagallo(specie,eta,genere,mutazione,dataNascita);
                        np1.aggiungiPappagallo(p, posizione);
                        System.out.println("Pappagallo inserito correttamente.");
                    }
                    catch (EccezionePosizioneNonValida ex)
                    {
                        System.out.println("Posizione non valida!");
                    }
                    catch (EccezionePosizioneOccupata ex)
                    {
                        System.out.println("Posizione occupata!");
                    }
                    break;
                case 3:
                        System.out.println("Posizione --> ");
                        posizione=tastiera.nextInt();

                        try 
                        {
                            p=np1.getPappagallo(posizione);
                            System.out.println("Pappagallo cercato:\n"+p.toString());
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida!");
                        } 
                        catch (EccezionePosizioneVuota ex) 
                        {
                            System.out.println("Posizione vuota!");
                        }
                        
                        break;
                case 4:
                        do
                        {
                            try
                            {
                                System.out.println("Posizione --> ");
                                posizione=tastiera.nextInt();
                                break;
                            }
                            catch (EccezionePosizioneNonValida ex) 
                            {
                                System.out.println("Posizione non valida");
                            } 
                            
                        }while(true);
        
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Il libro è stato rimosso correttamente");
        
                }break;
            
        }while(voceMenuScelta!=0);*/

        
        
        
    }
}

