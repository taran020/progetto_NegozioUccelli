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
import utilita.Menu;
import utilita.TextFile;
/**
 *
 * @author Studente
 */
public class NegozioPappagalli implements Serializable
{
    private final static int NUM_MAX_PAPPAGALLI=11;
    private Pappagallo[] pappagalli;
    
    /**
    * Costruttore della classe NegozioPappagalli che inizializza l'array di Pappagalli
    * con la dimensione massima specificata dalla costante NUM_MAX_PAPPAGALLI.
    */
    public NegozioPappagalli()
    {
        pappagalli=new Pappagallo[NUM_MAX_PAPPAGALLI];
    }
    
    /**
    * Restituisce il numero massimo di pappagalli che il negozio può contenere.
    *
    * @return Il numero massimo di pappagalli che il negozio può contenere.
    */
    public int getNumMaxPappagalli()
    {
        return NUM_MAX_PAPPAGALLI;
    }
    
    /**
    * Aggiunge un pappagallo nella posizione specificata all'interno del negozio.
    *
    * @param p Il pappagallo da aggiungere.
    * @param posizione La posizione in cui aggiungere il pappagallo.
    * @throws EccezionePosizioneNonValida Se la posizione specificata non è valida.
    * @throws EccezionePosizioneOccupata Se la posizione specificata è già occupata da un altro pappagallo.
    */
    public void aggiungiPappagallo(Pappagallo p, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        if (posizione<0 || posizione>=NUM_MAX_PAPPAGALLI)
           throw new EccezionePosizioneNonValida();
        if(pappagalli[posizione]!=null)
              throw new EccezionePosizioneOccupata();
        pappagalli[posizione]=p;
        
    }
    
    /**
    * Rimuove il pappagallo dalla posizione specificata all'interno del negozio.
    *
    * @param posizione La posizione da cui rimuovere il pappagallo.
    * @throws EccezionePosizioneNonValida Se la posizione specificata non è valida.
    * @throws EccezionePosizioneVuota Se la posizione specificata è vuota.
    */
    public void rimuoviPappagallo(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if(posizione<0 || posizione>NUM_MAX_PAPPAGALLI)
            throw new EccezionePosizioneNonValida();
 
        if (pappagalli[posizione]==null)
                throw new EccezionePosizioneVuota();
        pappagalli[posizione]=null;
         
    }

    /**
     * Restituisce il pappagallo nella posizione specificata all'interno del negozio.
     *
     * @param posizione La posizione del pappagallo da restituire.
     * @return Il pappagallo nella posizione specificata.
     * @throws EccezionePosizioneNonValida Se la posizione specificata non è valida.
     * @throws EccezionePosizioneVuota Se la posizione specificata è vuota.
     */
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
    
    /**
    * Restituisce un array di pappagalli che corrispondono alla specie specificata.
    *
    * @param specie La specie dei pappagalli da cercare.
    * @return Un array di pappagalli che corrispondono alla specie specificata.
    */
    public Pappagallo[] elencoPappagalliSpecie(String specie)
    {
        int c=0;
        Pappagallo p;
        Pappagallo[] elencoPappagalliSpecie;
        
        for(int i=0;i<NUM_MAX_PAPPAGALLI;i++)
        {
            try 
            {
                p=this.getPappagallo(i);
                if (p.getSpecie().equalsIgnoreCase(specie))
                    c++;   
            }
            catch (EccezionePosizioneNonValida ex)
            {
                //non succederà mai
            }
            catch (EccezionePosizioneVuota ex) 
            {
                    //non fare nulla.
            }
        }
        
        if (c==0)
            return null; //non ci sono pappagalli di quella specie.
        
        elencoPappagalliSpecie=new Pappagallo[c];
        
        c=0; //azzero il contatore per usarlo come contatore dell'array
        
        for(int i=0;i<NUM_MAX_PAPPAGALLI;i++)
        {
            try 
                {
                    p=this.getPappagallo(i);
                    if (p.getSpecie().equalsIgnoreCase(specie))
                    {
                        elencoPappagalliSpecie[c]=p;
                        c++;
                    } 
                }
                catch (EccezionePosizioneNonValida ex) 
                {
                       //non succederà mai
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla
                }
        }
        return elencoPappagalliSpecie;
    }
     
    /**
    * Scambia due elementi in un array di pappagalli.
    *
    * @param p L'array di pappagalli in cui scambiare gli elementi.
    * @param i L'indice del primo elemento.
    * @param j L'indice del secondo elemento.
    */
    public static void scambia(Pappagallo[] p, int i,int j)
    {
        Pappagallo x;
        x=p[i];
        p[i]=p[j];
        p[j]=x;
    }
     
    /**
    * Ordina gli elementi di un array di pappagalli per prezzo crescente.
    *
    * @return Un array di pappagalli ordinato per prezzo crescente.
    */
    public Pappagallo[] ordinaPrezzoCrescente() 
    {
        int lunghezza = pappagalli.length;
        Pappagallo[] pOrdinato = new Pappagallo[lunghezza];
        
        for (int i = 0; i < lunghezza; i++)
        {
            if(pappagalli[i]!=null)
                pOrdinato[i] = pappagalli[i];
        }

        for (int i = 0; i < lunghezza - 1; i++)
        {
            for (int j = i + 1; j < lunghezza; j++)
            {
                // Se il prezzo di pOrdinato[j] è inferiore a quello di pOrdinato[i], li scambio
                if (pOrdinato[j] != null && pOrdinato[i] != null && pOrdinato[j].prezzo() < pOrdinato[i].prezzo())
                    scambia(pOrdinato, i, j);
            }
        }

        return pOrdinato;
    }

    /**
    * Consente al proprietario del negozio di modificare i dati di un pappagallo.
    * Il metodo presenta un menu che permette di selezionare quale attributo del pappagallo modificare.
    */
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

    /**
    * Esporta i dati dei pappagalli in un file CSV.
    */
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
    
    /**
    * Importa i dati dei pappagalli da un file CSV.
    */
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

    /**
    * Serializza l'oggetto NegozioPappagalli e lo salva su un file binario.
    */
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
      
    /**
    * Deserializza l'oggetto NegozioPappagalli da un file binario.
    */
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
     
    /**
    * Restituisce una stringa rappresentante lo stato dell'oggetto NegozioPappagalli.
    *
    * @return Una stringa rappresentante lo stato dell'oggetto.
    */
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

