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
    private String specie="";
    private int eta;
    private String genere="";
    private String mutazione="";
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

    @Override
    public String toString() 
    {
        return "Uccello{" + "specie=" + specie + ", età=" + eta + ", genere=" + genere + ", mutazione=" + mutazione + ", idUccello=" + idUccello + ", dataNascita=" + dataNascita + "}";
    }

    

    
    
    
}
