/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Studente
 */
public class Pappagallo 
{
    private String specie;
    private int eta;
    private String genere;
    private String mutazione;
    private static int nextId=1;
    private int idPappagallo;
    private LocalDate dataNascita;
    
    /**
     * Costruttore
     * @param specie 
     * @param eta 
     * @param genere maschio o femmina
     * @param mutazione colore del pappagallo
     * @param dataNascita 
     */
    public Pappagallo(String specie, int eta, String genere, String mutazione, LocalDate dataNascita)
    {
        idPappagallo=nextId;
        this.specie = specie;
        this.eta = eta;
        this.genere = genere;
        this.mutazione = mutazione;
        this.dataNascita=dataNascita;
        nextId++;
        prezzo();
    }
    
    public String getSpecie() 
    {
        return specie;
    }

    public void setSpecie(String specie) 
    {
        this.specie = specie;
    }

    public int getEta() 
    {
        return eta;
    }

    public void setEta(int eta) 
    {
        this.eta = eta;
        
        if(eta<0)
           this.eta = 0;
    }

    public String getGenere() 
    {
        return genere.toUpperCase();
    }

    public void setGenere(String genere) 
    {
        this.genere = genere;
    }

    public String getMutazione() 
    {
        return mutazione;
    }

    public void setMutazione(String mutazione) 
    {
        this.mutazione = mutazione;
    }
    
    public int getIdPappagallo()
    {
        return idPappagallo;
    }
    
    public void setDataNascita(LocalDate dataNascita) 
    {
        this.dataNascita = dataNascita;
    }
    
    public LocalDate getDataNascita() 
    {
        return dataNascita;
    }
    
    /**
     * Calcola il prezzo del pappagallo in base alla specie e mutazione
     * @return 
     */
    public double prezzo()
    {
        double prezzo=0;
        switch(specie.toLowerCase())
        {
            case "calopsitta":
                switch (mutazione.toLowerCase()) 
                {
                    case "faccia bianca":
                        prezzo += 40;
                        break;
                    case "perlata":
                        prezzo += 30; 
                        break;
                    case "cinnamon":
                        prezzo += 60;
                        break;
                    case "lutino":
                        prezzo += 50;
                        break;
                    case "albino":
                        prezzo += 100;
                        break;
                    case "ancestrale":
                        prezzo += 25;
                        break;
                    default:
                        this.setMutazione("Mutazione non conosciuta");
                        break;
                }
                break;
                
            case "cocorita":
                switch (mutazione.toLowerCase()) 
                {
                    case "blu":
                        prezzo += 10;
                        break;
                    case "verde":
                        prezzo += 5; 
                        break;
                    case "giallo":
                        prezzo += 10;
                        break;
                    case "lutino":
                        prezzo += 15;
                        break;
                    case "albino":
                        prezzo += 25;
                        break;
                    case "faccia bianca":
                        prezzo += 12;
                        break;
                    case "grigio":
                        prezzo += 8;
                        break;
                    default:
                        this.setMutazione("Mutazione non conosciuta");
                        break;
                }
                break;
                
            case "inseparabile":
                switch (mutazione.toLowerCase())
                {
                    case "cremino":
                        prezzo += 25.0; 
                        break;
                    case "avorio cobalto":
                        prezzo += 15.0; 
                        break;
                    case "mascherato":
                        prezzo += 30.0; 
                        break;
                    case "albino":
                        prezzo += 35.0; 
                        break;
                    case "lutino":
                        prezzo += 40.0; 
                        break;
                    case "giallo":
                        prezzo += 20.0; 
                        break;
                    case "arancio":
                        prezzo += 22.0; 
                        break;
                    default:
                        this.setMutazione("Mutazione non conosciuta");
                        break;
                }
                break;
            default:
                this.setSpecie("Specie non conosciuta");
                break;
        }
        return prezzo;
    }
    
    /**
     * 
     * Confronta due pappagalli tra loro
     * @return 
     */
    public boolean equals(Object o)
    {
        Pappagallo p=(Pappagallo) o;
        if(getSpecie().equals(p.getSpecie()) && getEta()==p.getEta() && getGenere().equals(p.getGenere()) && getMutazione().equals(p.getMutazione()) && getDataNascita().equals(p.getDataNascita()))
            return true;
        else
            return false;

    }
    
    /**
     *  Reimposta il valore della variabile statica nextId a 1.
 *   *  è utilizzato per evitare problemi nei Test
     */
    public static void resetNextId() 
    {
        nextId = 1;
    }
    
    /**
     * Restituisce una stringa che contiene i dati di un pappagallo
     * @return 
     */
    @Override
    public String toString() 
    {
        return getIdPappagallo()+";"+getSpecie()+";"+ getEta()+";"+getGenere()+";"+getMutazione()+";"+getDataNascita()+";"+prezzo()+"€";
    }

}
