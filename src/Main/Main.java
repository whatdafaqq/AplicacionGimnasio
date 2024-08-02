/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Data.ClaseData;
import Data.EntrenadorData;
import Data.MembresiaData;
import Data.SocioData;
import Entidades.Membresia;
import Entidades.Socio;
import java.time.LocalDate;

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
//        Socio s1= new Socio(1, "123123", "rama", "aval", 12, "rama@gmail.com", "2323-23423", true);
        Socio s2= new Socio(1, "123123", "jacinto", "lopez", 23, "asdasd@gmail.com", "2323-67678", true);
//       sd.agregarSocio(s2);
        
        //Agregar Membresia
        Membresia m1 = new Membresia(0, s2, 3, LocalDate.of(2024, 7, 27), LocalDate.of(2024, 4, 27), 354, true);
        md.agregarMembresia(m1);
        //ListarSocios 
           System.out.println(sd.listarSocios());
        //ListarMembresia
        System.out.println(md.listarMembresias());
        
        //
    }
}
