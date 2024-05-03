/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto;
import eccezioni.*;

/**
 *
 * @author Studente
 */
public class NegozioPappagalli
{
    private final static int NUM_MAX_PAPPAGALLI=10;
    private Pappagallo[] pappagalli;
    
    public NegozioPappagalli()
    {
        pappagalli=new Pappagallo[NUM_MAX_PAPPAGALLI];
    }
    
    /*public NegozioPappagalli(NegozioPappagalli np)
    {
         pappagalli=new Pappagallo[NUM_MAX_PAPPAGALLI];
         Pappagallo p;
         for(int i=0; i<p.getNumMaxPappagalli();i++)
         {
             try 
             {
                 p=np.getVolume(i);
                 if (lib!=null)        
                     this.setVolume(lib, i);
             } 
             catch (EccezionePosizioneNonValida ex) 
             {
                 //non succederà mai
             } 
             catch (EccezionePosizioneVuota ex) 
             {
                 //non fare nulla
             } 
             catch (EccezionePosizioneOccupata ex) 
             {
                 //non succederà mai.
             }
         }
    }*/
    
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
