/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto;

import java.util.Date;

/**
 *
 * @author taran
 */
public class App 
{

    public static void main(String[] args) 
    {
        Date dataNascita=new Date(2008, 11, 20);
        Uccello u1=new Uccello("calopsitta", 1, "sdvhh", "albino", dataNascita);
        
        System.out.println(u1.toString());
    }
}
