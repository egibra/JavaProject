/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class MultisetGreitaveika {
    Kamera[] KameruArray;
    Multiset<Kamera> KamerosLinked = new Multiset<>();
    Random ag = new Random(); 
    static int[] tiriamiKiekiai = {100_000, 200_000, 400_000, 800_000};
    void generuotiKameras(int kiekis){
        
    
       String[][] am = { 
          {"GoPro", "5", "4", "3", "3+", "2"},
          {"Nikon", "C200", "C500", "C120", "D200", "D400"},
          {"Nikon", "Beta220", "Beta400", "Beta700"},
          {"Sony", "Alpha200", "Alpha300", "Alpha400", "Alpha500"},
          
       };
        KameruArray= new Kamera[kiekis];
        ag.setSeed(2017);
        for(int i=0;i<kiekis;i++){
            int ma = ag.nextInt(am.length);       
            int mo = ag.nextInt(am[ma].length-1)+1;
             boolean naudota = true;
             if(ag.nextInt(10)%2 != 0)
              naudota = false;   
            
            KameruArray[i]= new Kamera(
                    am[ma][0],  // gamyba
                    am[ma][mo],  // modelis
                    2001 + ag.nextInt(15),           // metai tarp 2001 ir 2016
                    naudota,
                    300 + ag.nextDouble()*1000); // kaina tarp 300 ir 1300

            }
        Collections.shuffle(Arrays.asList(KameruArray));
    }
   
      void tyrimas12() {
        long GetIndex = 0;
        long containstime = 0;
        
        System.out.println("\n================================================================");
        System.out.println("\n            GetIndex bei contains greitaveikos tyrimas          ");
        System.out.println("\n================================================================");

        
        for (int i = 0; i < tiriamiKiekiai.length; i++) {
            generuotiKameras(tiriamiKiekiai[i]);
            Multiset<Integer> intList = new Multiset<>();
            for (Kamera p : KameruArray) {
                intList.put(p.GetPagaminimoMetai());
            }
                        
            System.out.println("\ntiriamų kamerų skaičius: " + tiriamiKiekiai[i]/ 1000 + "k");
            
            long t2, t1;
            t1 = System.nanoTime();
            
            for (int j = 0; j < tiriamiKiekiai[i]; j++) {
                intList.getIndex(KameruArray[7].GetPagaminimoMetai());
            }
            t2 = System.nanoTime();
            GetIndex = t2 - t1;
            
            t1 = System.nanoTime();
            for (int j = 0; j < tiriamiKiekiai[i]; j++)
            {
                intList.contains(KameruArray[7].GetPagaminimoMetai());
            }
            t2 = System.nanoTime();
            containstime = t2 - t1;
            
            System.out.println("GetIndex :" + GetIndex / 1e6 + "   | contains:  " + containstime / 1e6);
            
             System.out.println("\n----------------------------------------------------------------");
        }
      } 
    public void tyrimoPasirinkimas()
    {
        tyrimas12();
    }
    
}
