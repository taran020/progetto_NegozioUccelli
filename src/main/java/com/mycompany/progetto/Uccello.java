/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto;

import java.util.Date;

/**
 *
 * @author Studente
 */
public class Uccello 
{
    private String specie;
    private int eta;
    private String genere;
    private String mutazione;
    private static int nextId=1;
    private int idUccello;
    private Date dataNascita;
    
    public Uccello(String specie, int eta, String genere, String mutazione, Date dataNascita)
    {
        idUccello=nextId;
        this.specie = specie;
        this.eta = eta;
        this.genere = genere;
        this.mutazione = mutazione;
        this.dataNascita=dataNascita;
        nextId++;
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
    }

    public String getGenere() 
    {
        return genere;
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
    
    public int getIdUccello()
    {
        return idUccello;
    }
    
    public void setDataNascita(Date dataNascita) 
    {
        this.dataNascita = dataNascita;
    }
    public Date getDataNascita() 
    {
        return dataNascita;
    }
    
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
                    case default:
                        System.out.println("Mutazione non conosciuta");
                }
                
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
                    case default:
                        System.out.println("Mutazione non conosciuta");
                }
                
        }
        return prezzo;
    }
    
    @Override
    public String toString() 
    {
        return "Uccello{" + "specie=" + specie + ", età=" + eta + ", genere=" + genere + ", mutazione=" + mutazione + ", idUccello=" + idUccello + ", dataNascita=" + dataNascita + ", prezzo=" + prezzo()+ "}";
    }

}
