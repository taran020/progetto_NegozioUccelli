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
import utilita.Menu;

/**
 *
 * @author taran
 */
public class App 
{

    public static void main(String[] args) 
    {
            
        int numeroVociMenu=12;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scanner tastiera=new Scanner(System.in);

        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i pappagalli";
        vociMenu[2]="2 -->\tAggiungi pappagallo";
        vociMenu[3]="3 -->\tCerca pappagallo";
        vociMenu[4]="4 -->\tElimina pappagallo";
        vociMenu[5]="5 -->\tVisualizza pappagalli di una specifica specie";
        vociMenu[6]="6 -->\tVisualizza pappagalli presenti ordinati per prezzo crescente";
        vociMenu[7]="7 -->\tEsporta pappagalli in formato CSV";
        vociMenu[8]="8 -->\tImporta pappagalli dal file CSV";
        vociMenu[9]="9 -->\tSalva dati pappagallo";
        vociMenu[10]="10 -->\tCarica dati pappagallo";
        vociMenu[11]="11 -->\tModifica dati pappagallo";

        menu=new Menu(vociMenu);

        String specie,mutazione,genere;
        int eta;
        int g,m,a;
        int posizione;
        LocalDate dataNascita = null;
        Pappagallo p = null;
        Pappagallo[] elencoPappagalliSpecie;
        Pappagallo[] pOrdinato;
        NegozioPappagalli np1=new NegozioPappagalli();


        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: 
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    System.out.println(np1.toString());
                    break;
                case 2:
                    tastiera.nextLine();
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
                        p.setEta(eta);
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
                    System.out.println("Posizione --> ");
                    posizione=tastiera.nextInt();
                    try
                    {
                        np1.rimuoviPappagallo(posizione);
                        System.out.println("Il pappagallo è stato rimosso correttamente");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("La posizione è già vuota. Nessun pappagallo è stato rimosso");
                    }

                    
                    break;
                case 5:
                    System.out.println("Specie --> ");
                    specie=tastiera.nextLine();
                    elencoPappagalliSpecie=np1.elencoPappagalliSpecie(specie);
                    if (elencoPappagalliSpecie!=null)
                    {
                        for(int i=0;i<elencoPappagalliSpecie.length;i++)
                        {
                            System.out.println(elencoPappagalliSpecie[i]);
                        }
                    }
                    else
                        System.out.println("Nessun pappagallo presente per la specie scelta.");
                    break;
                case 6:
                    pOrdinato=np1.ordinaPrezzoCrescente();

                    int x=0;
                    for(int i=0;i<pOrdinato.length;i++)
                    {
                        if(pOrdinato[i]!=null)
                        {
                            System.out.println(pOrdinato[i]);
                            x++;
                        }
                    }
                    
                    if(x==0)
                        System.out.println("Il negozio è vuoto");
                    
                    break;
                case 7:
                    np1.esportaFileCSV();
                    break;
                case 8: 
                    np1.importaFileCSV();
                    break;
                case 9:               
                    np1.serializzazione(np1);
                    break;
                case 10:
                    np1.deserializzazione(np1);
                    break;
                case 11:
                    boolean negozioVuoto = true;
                    int i=0;
                    while (i < np1.getNumMaxPappagalli()) 
                    {
                        try 
                        {
                            if (np1.getPappagallo(i) != null)
                            {
                                negozioVuoto = false;
                                break;
                            }
                        }
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida");
                        }
                        catch (EccezionePosizioneVuota ex) 
                        {
                            i++;
                        }
                    }

                    if (negozioVuoto)
                        System.out.println("Il negozio è vuoto.");
                    else
                        np1.modifica();
                    break;
                    
            }       
            
        }while(voceMenuScelta!=0);
 
    }
}

