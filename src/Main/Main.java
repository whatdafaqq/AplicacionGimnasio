/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Data.ClaseData;
import Data.EntrenadorData;
import Data.MembresiaData;
import Data.SocioData;
import Entidades.Socio;

/**
 *
 * @author ramir
 */
public class Main {
    public static void main(String[] args) {
        
        //Instanciaciones
        SocioData sd = new SocioData();
        MembresiaData md = new MembresiaData();
        EntrenadorData ed = new EntrenadorData();
        ClaseData cd = new ClaseData();
        
        
        //Agregar Socio
        Socio s1= new Socio(1, "123123", "rama", "aval", 12, "rama@gmail.com", "2323-23423", true);
        Socio s2= new Socio(2, "123123", "jacinto", "lopez", 23, "asdasd@gmail.com", "2323-67678", true);
        sd.agregarSocio(s1);
        
        //ListarSocios 
           System.out.println( sd.listarSocios());
        
        
        //
    }
}
