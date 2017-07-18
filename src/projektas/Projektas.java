/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas;
import java.util.List;
import java.io.PrintStream;
/**
 *
 * @author Acer
 */
public class Projektas {
    
    Multiset <Kamera> KameruParduotuve = new Multiset<>(25);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     new Projektas().metodoParinkimas();  
     new MultisetGreitaveika().tyrimoPasirinkimas();
    }
       void metodoParinkimas()
       {
        AtliktiBandymus();
       // papildytiSąrašą();
        
       }
        public void papildytiSąrašą(){
            
        String Stringas= "Nikon C200 2015 true 299,99";
        Kamera nauja = new Kamera(Stringas);
        KameruParduotuve.put(nauja);
        Stringas = "Sony Killer 2014 false 200,99";
        nauja = new Kamera(Stringas);
        KameruParduotuve.put(nauja);
        System.out.println("Kamerų parduotuvė papildyta dviem naujom kamerom: ");
        KameruParduotuve.SpausdintiUnikalius();
 
    }
       public void AtliktiBandymus()
       {
       Kamera nauja = new Kamera();
       Kamera a3 = new Kamera.Builder().BuildRandom();
       Kamera a4 = new Kamera("GoPro  2   2011   true   100,0");
       Kamera a5 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a6 = new Kamera("GoPro  +LCD    2015   false   380,5");
       Kamera a7 = new Kamera("Sony     Cyber-shot    2016   true  990,99");
       Kamera a8 = new Kamera("Sony     A6500    2015   true  700,0");
       Kamera a9 = new Kamera("Nikon     Beta2000    2015  true  400,0");
       Kamera a10 = new Kamera("Nikon     Beta2000    2015  true  400,0");
       Kamera a11 = new Kamera("Nikon     Beta2000    2015  true  400,0");
       Kamera a12 = new Kamera("Nikon     Beta2000    2015  true  400,0");
       Kamera a13 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a14 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a15 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a16 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a17 = new Kamera("GoPro  3+  2013   false   200,0");
       Kamera a18 = new Kamera("GoPro  3+  2013   false   200,0");
       
       KameruParduotuve.put(a3);
       KameruParduotuve.put(a4);
       KameruParduotuve.put(a5);
       KameruParduotuve.put(a6);
       KameruParduotuve.put(a7);
       KameruParduotuve.put(a8);
       KameruParduotuve.put(a9);
       KameruParduotuve.put(a10);
       KameruParduotuve.put(a11);
       KameruParduotuve.put(a12);
       KameruParduotuve.put(a13);
       KameruParduotuve.put(a14);
       KameruParduotuve.put(a15);
       KameruParduotuve.put(a16);
       KameruParduotuve.put(a17);
       KameruParduotuve.put(a18);
       System.out.println("Kamerų parduotuvėje iš viso turime " + KameruParduotuve.size() + " kamerų.");
       System.out.println("Visų kamerų sąrašas: ");
       KameruParduotuve.SpausdintiVisa();
       System.out.println("");
       System.out.println("Unikalių kamerų sąrašas: ");    
       KameruParduotuve.SpausdintiUnikalius();
       System.out.println("");
       System.out.println("Tikrinama ar yra pakankamas kiekis produktų: ");
       KameruParduotuve.GalimybeIsigyti(a9, 4);
       KameruParduotuve.GalimybeIsigyti(a9, 5);
       System.out.println("Kadangi yra galimybė nusipirkti 4 Nikon kameras, nuperkant jos pašalinamos iš sarašo, likęs sąrašas: ");
       KameruParduotuve.remove(a9);
       KameruParduotuve.remove(a9);
       KameruParduotuve.remove(a9);
       KameruParduotuve.remove(a9);
       System.out.println("Likęs pilnas sąrašas: ");
       KameruParduotuve.SpausdintiVisa();
       System.out.println("");
       System.out.println("");
       System.out.println("Likęs unikalių produktų sąrašas: ");
       KameruParduotuve.SpausdintiUnikalius();
       
       }
       
}
