/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto;

/**
 *
 * @author Studente
 */
public class Uccello 
{
    private String nome;
    private String specie;
    private int eta;
    private String genere;
    private String mutazione;

    public Uccello(String nome, String specie, int eta, String genere, String mutazione)
    {
        this.nome = nome;
        this.specie = specie;
        this.eta = eta;
        this.genere = genere;
        this.mutazione = mutazione;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getMutazione() {
        return mutazione;
    }

    public void setMutazione(String mutazione) {
        this.mutazione = mutazione;
    }

    @Override
    public String toString() {
        return "Uccello{" + "nome=" + nome + ", specie=" + specie + ", eta=" + eta + ", genere=" + genere + ", mutazione=" + mutazione + '}';
    }

    

    
    
    
}
