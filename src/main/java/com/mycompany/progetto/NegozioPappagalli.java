/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto;
import eccezioni.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import utilita.TextFile;
/**
 *
 * @author Studente
 */
public class NegozioPappagalli implements Serializable
{
    private final static int NUM_MAX_PAPPAGALLI=10;
    private Pappagallo[] pappagalli;
    
    public NegozioPappagalli()
    {
        pappagalli=new Pappagallo[NUM_MAX_PAPPAGALLI];
    }
    
    public void aggiungiPappagallo(Pappagallo p, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        if (posizione<0 || posizione>=NUM_MAX_PAPPAGALLI)
           throw new EccezionePosizioneNonValida();
        if(pappagalli[posizione]!=null)
              throw new EccezionePosizioneOccupata();
        pappagalli[posizione]=p;
        
    }
    
    public void rimuoviPappagallo(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(posizione<0 || posizione>NUM_MAX_PAPPAGALLI)
            throw new EccezionePosizioneNonValida();
 
        if (pappagalli[posizione]==null)
                throw new EccezionePosizioneVuota();
        pappagalli[posizione]=null;
         
    }


    public Pappagallo getPappagallo(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        
        if (posizione < 0 || posizione >= NUM_MAX_PAPPAGALLI) 
        {
            throw new EccezionePosizioneNonValida();
        }

        if (pappagalli[posizione] == null) 
        {
            throw new EccezionePosizioneVuota();
        }

        return pappagalli[posizione];
    }

     
     public String elencoPappagalliSpecie(String specie)
     {
         String s="";
        for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++) 
        {
            try
            {
                if (pappagalli[i].getSpecie().equals(specie))
                    s+="\n" + pappagalli[i];
            }
            catch (NullPointerException e) 
            {
                //Non fare nulla
            }
            
        }

        return s;
    }
     
    public static void scambia(Pappagallo[] p, int i,int j)
    {
        Pappagallo x;
        x=p[i];
        p[i]=p[j];
        p[j]=x;
    }
     
    public String OrdinaPrezzoCrescente()
    {
        String s="";
        int lunghezza=pappagalli.length;
        
        Pappagallo[] pOrdinato=new Pappagallo[lunghezza];
        for(int i=0;i<lunghezza;i++)
            pOrdinato[i]=pappagalli[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                try 
                {
                    if (pOrdinato[j].prezzo()<pOrdinato[i].prezzo())
                        scambia(pOrdinato, i, j);
                }
                catch (NullPointerException e)
                {
                    
                }
                
            }
        }
        
       for(int i=0;i<lunghezza;i++)
           if(!(pOrdinato[i]==null))
               s+="\n"+pOrdinato[i].toString();
      
       return s;
    }
     
    public void modifica()
    {
        int numeroVociMenu=5;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scanner tastiera=new Scanner(System.in);
        
        int idPappagallo;
        String nuovaSpecie;
        int nuovaEta;
        String nuovoGenere;
        String nuovaMutazione;
        
      //  System.out.println("MODIFICA:\n");
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tSpecie";
        vociMenu[2]="2 -->\tEtà";
        vociMenu[3]="3 -->\tGenere";
        vociMenu[4]="4 -->\tMutazione";
        
        menu=new Menu(vociMenu);
        
        do
        {
             System.out.println("MODIFICA:\n");
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: 
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    System.out.println("Inserisci Id --> ");
                    idPappagallo=tastiera.nextInt();
                    
                    for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++) 
                    {
                        try 
                        {
                            if (pappagalli[i].getIdPappagallo()==idPappagallo)
                            {
                                tastiera.nextLine();
                                System.out.println("Inserisci la nuova specie --> ");
                                nuovaSpecie=tastiera.nextLine();

                                pappagalli[i].setSpecie(nuovaSpecie);
                            }
                        } 
                        catch (NullPointerException e)
                        {
                            //Non fare nulla
                        }
                    }
                    break;
                case 2:
                    System.out.println("Inserisci Id --> ");
                    idPappagallo=tastiera.nextInt();
                    
                    for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++) 
                    {
                        try 
                        {
                            if (pappagalli[i].getIdPappagallo()==idPappagallo)
                            {
                                tastiera.nextLine();
                                System.out.println("Inserisci la nuova età --> ");
                                nuovaEta=tastiera.nextInt();

                                pappagalli[i].setEta(nuovaEta);
                            }
                        } 
                        catch (NullPointerException e)
                        {
                            //Non fare nulla
                        }
                    }
                    break;
                case 3:
                    System.out.println("Inserisci Id --> ");
                    idPappagallo=tastiera.nextInt();
                    
                    for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++) 
                    {
                        try 
                        {
                            if (pappagalli[i].getIdPappagallo()==idPappagallo)
                            {
                                tastiera.nextLine();
                                System.out.println("Inserisci il nuovo genere --> ");
                                nuovoGenere=tastiera.nextLine();

                                pappagalli[i].setGenere(nuovoGenere);
                            }
                        } 
                        catch (NullPointerException e)
                        {
                            //Non fare nulla
                        }
                    }
                    break;
                case 4:
                    System.out.println("Inserisci Id --> ");
                    idPappagallo=tastiera.nextInt();
                    
                    for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++) 
                    {
                        try 
                        {
                            if (pappagalli[i].getIdPappagallo()==idPappagallo)
                            {
                                tastiera.nextLine();
                                System.out.println("Inserisci la nuova mutazione --> ");
                                nuovaMutazione=tastiera.nextLine();

                                pappagalli[i].setMutazione(nuovaMutazione);
                                pappagalli[i].prezzo();
                            }
                        } 
                        catch (NullPointerException e)
                        {
                            //Non fare nulla
                        }
                    }
                    break;
            
            }
        }while(voceMenuScelta!=0);
    }

    public void esportaFileCSV()
    {
        String nomeFileCSV = "pappagalli.csv";
        try
        {
            TextFile f1 = new TextFile(nomeFileCSV, 'W');

            for (int i = 0; i < NUM_MAX_PAPPAGALLI; i++)
            {
                try 
                {
                    Pappagallo p = getPappagallo(i);
                    String datiVolume = i + ";" + p.getIdPappagallo() + ";" + p.getSpecie() + ";" + p.getEta() + ";" + p.getGenere() + ";" + p.getMutazione() + ";" + p.getDataNascita() + ";" + p.prezzo();
                    f1.toFile(datiVolume);
                } catch (EccezionePosizioneNonValida ex) {
                    // Non dovrebbe succedere
                } catch (EccezionePosizioneVuota ex) {
                    // Salta questa posizione vuota
                } catch (FileException ex) {
                    System.out.println("Errore nella scrittura su file: " + ex.getMessage());
                }
            }
             f1.closeFile(); 
            System.out.println("Esportazione completata con successo.");
        } 
        catch (IOException e) 
        {
            System.out.println("Errore durante l'esportazione dei dati: " + e.getMessage());
        }
        
    }

    
    public void importaFileCSV()
    {
        String rigaLetta;
        String[] datiVolume;
        try 
        {   
            //Importa da file CSV
            String nomeFileCSV="pappagalli.csv";
            TextFile f1 = new TextFile(nomeFileCSV,'R');
            String specie;
            int eta;
            String genere;
            String mutazione;
            int idPappagallo;
            LocalDate dataNascita;
            double prezzo;
            int posizione;
            
            do
            {
                try
                {
                    rigaLetta=f1.fromFile();
                    datiVolume=rigaLetta.split(";");
                    posizione=Integer.parseInt(datiVolume[0]);
                    idPappagallo=Integer.parseInt(datiVolume[1]);
                    specie=datiVolume[2];
                    eta=Integer.parseInt(datiVolume[3]);
                    genere=datiVolume[4];
                    mutazione=datiVolume[5];
                    dataNascita=LocalDate.parse(datiVolume[6]);
                    prezzo=Double.parseDouble(datiVolume[7]);
                            
                    Pappagallo p = new Pappagallo(specie, eta, genere, mutazione,dataNascita);
                    try 
                    {
                        aggiungiPappagallo(p, posizione);
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                         System.out.println("Errore: posizione "+posizione+ " non corretta!");
                    }
                    catch (EccezionePosizioneOccupata ex) 
                    {
                         System.out.println("Posizione "+posizione+" è occupata");
                    }
                }
                catch (FileException ex) 
                {
                    //fine del file
                    f1.closeFile();
                    System.out.println("Fine operazione di caricamento");
                    break;
                }
            }while(true);                
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file!");
        } 
    }

    public void serializzazione(NegozioPappagalli np)
    {
        try 
        {
            String nomeFileBinario="NegozioPappagalli.bin";
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBinario));
            writer.writeObject(np);
            writer.flush();
            writer.close();
            System.out.println("Salvataggio avvenuto correttamente");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File non trovato");
        } 
        catch (IOException ex) 
        {
             System.out.println("Impossibile accedere al file");
        }
    }
      
       public void deserializzazione(NegozioPappagalli np)
    {
        String nomeFileBinario="NegozioPappagalli.bin";
        try 
        {
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
            np=(NegozioPappagalli)reader.readObject();
            reader.close();
            System.out.println("Caricamento effettuato correttamente");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File non trovato");
        } 
        catch (IOException ex) 
        {
             System.out.println("Impossibile accedere al file");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Impossibile leggere il dato memorizzato");
        }
    }
    
      
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_PAPPAGALLI;i++)
        {
            if (pappagalli[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+pappagalli[i].toString()+"\n";
        }
        
        return s;
    }
    
}

