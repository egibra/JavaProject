/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Kamera  {
    final static private int priimtinųMetųRiba = 2005;   
    final static private double  MinKaina = 100.0; 
    final static private double MaxKaina = 1400.0;
    final static private int EsamiMetai = LocalDate.now().getYear();
    
    private String Gamintojas; 
    private String Modelis; 
    private int PagaminimoMetai; 
    private boolean ArNaudota; 
    private double Kaina; 
    
    public Kamera ()
    {}
    public Kamera (String Gamintojas, String Modelis, int PagaminimoMetai, boolean ArNaudota, double Kaina)
    {
        this.Gamintojas = Gamintojas;
        this.Modelis = Modelis; 
        this.PagaminimoMetai = PagaminimoMetai;
        this.ArNaudota = ArNaudota;
        this.Kaina = Kaina;
    }
    public Kamera(Builder builder) {
        this.Gamintojas = builder.Gamintojas;
        this.Modelis = builder.Modelis;
        this.PagaminimoMetai = builder.PagaminimoMetai;
        this.ArNaudota = builder.ArNaudota;
        this.Kaina = builder.Kaina;
        validate();
    }
    public static class Builder 
    {
        private final static Random RANDOM = new Random(1949);
           String[][] am = { // galimų automobilių markių ir jų modelių masyvas
          {"GoPro", "5", "4", "3", "3+", "2"},
          {"Nikon", "C200", "C500", "C120", "D200", "D400"},
          {"Nikon", "Beta220", "Beta400", "Beta700"},
          {"Sony", "Alpha200", "Alpha300", "Alpha400", "Alpha500"},
          
       };
           private String Gamintojas = "";
           private String Modelis = "";
           private int PagaminimoMetai = -1;
           private boolean ArNaudota = false;
           private double Kaina = -1.0;
           
           public Kamera build ()
           {
               return new Kamera(this);
           }
           
           public Kamera BuildRandom()
           {
       
            int ma = RANDOM.nextInt(am.length);        // markės indeksas  0..
            int mo = RANDOM.nextInt(am[ma].length-1)+1;// modelio indeksas 1..
             boolean naudota = true;
             if(RANDOM.nextInt(10)%2 != 0)
              naudota = false;   
            return new Kamera(
                     am[ma][0],
                     am[ma][mo],
                    priimtinųMetųRiba + RANDOM.nextInt(EsamiMetai -priimtinųMetųRiba),      // metai tarp 2001 ir 2016
                    naudota,
                    300 + RANDOM.nextDouble()*1000);                                         // kaina tarp 300 ir 1300   
           }
            public Builder Gamintojas(String Gamintojas) {
            this.Gamintojas = Gamintojas;
            return this;
        }

        public Builder Modelis(String Modelis) {
            this.Modelis = Modelis;
            return this;
        }

        public Builder PagaminimoMetai(int PagaminimoMetai) {
            this.PagaminimoMetai = PagaminimoMetai;
            return this;
        }

        public Builder ArNaudota(boolean ArNaudota) {
            this.ArNaudota = ArNaudota;
            return this;
        }

        public Builder Kaina(double Kaina) {
            this.Kaina = Kaina;
            return this;
        }
       
    
    }

    public String GetGamintojas ()
    {
        return Gamintojas;
    }
    public String GetModelis ()
    {
        return Modelis;
    }
    public int GetPagaminimoMetai ()
    {
        return PagaminimoMetai;
    }
    public boolean GetArNaudota()
    {
        return ArNaudota;
    }
    public double GetKaina()
    {
        return Kaina;
    }
    public void SetGamintojas(String Gamintojas)
    {
    this.Gamintojas = Gamintojas;
    }
    public void SetModelis (String Modelis)
    {
    this.Modelis = Modelis;
    }
    public void SetPagaminimoMetai(int PagaminimoMetai)
    {
    this.PagaminimoMetai = PagaminimoMetai;
    }
    public void SetArNaudota(boolean ArNaudota)
    {
    this.ArNaudota = ArNaudota;
    }
    public void SetKaina (double Kaina)
    {
    this.Kaina = Kaina;
    }
    public Kamera(String dataString)
    {
        this.parse(dataString);
    }
    
    
    public Kamera create (String DataString)
    {
       Kamera a = new Kamera();
       a.parse(DataString);
       return a;
    }

    @Override 
    public boolean equals(Object objektas)
    {
        Kamera o = (Kamera) objektas;
        boolean lygus = false;
        if (o.Gamintojas.compareTo(Gamintojas) == 0 && o.Modelis.compareTo(Modelis) == 0)      
            lygus = true;
        
        return lygus;
    }
    
    public final void parse(String dataString) {
        try {   // ed - tai elementarūs duomenys, atskirti tarpais
            Scanner ed = new Scanner(dataString);
            Gamintojas  = ed.next();
            Modelis = ed.next();
            PagaminimoMetai = ed.nextInt();
            ArNaudota    = ed.nextBoolean();
            SetKaina(ed.nextDouble());
        } catch (InputMismatchException  e) {
            //Ks.ern("Blogas duomenų formatas apie kamera -> " + dataString);
        } catch (NoSuchElementException e) {
           // Ks.ern("Trūksta duomenų apie apie kamera -> " + dataString);
        }
    }
//        public final static Comparator pagalMetusKainą = new Comparator() {
//       @Override
//       public int compare(Object o1, Object o2) {
//          Kamera a1 = (Kamera) o1;
//          Kamera a2 = (Kamera) o2;
//          // metai mažėjančia tvarka, esant vienodiems lyginama kaina
//          if(a1.GetPagaminimoMetai() < a2.GetPagaminimoMetai()) return 1;
//          if(a1.GetPagaminimoMetai() > a2.GetPagaminimoMetai()) return -1;
//          if(a1.GetKaina() < a2.GetKaina()) return 1;
//          if(a1.GetKaina() > a2.GetKaina()) return -1;
//          return 0;
//       }
//    };
//        public final static Comparator pagalModeli = new Comparator() {
//       @Override
//       public int compare(Object p1, Object p2) {
//          return ((Kamera)p1).GetModelis().compareTo(((Kamera)p2).GetModelis());
//       }
//    };
//           public final static Comparator pagalKainą = new Comparator() {
//       @Override
//       public int compare(Object o1, Object o2) {
//          double k1 = ((Kamera) o1).GetKaina();
//          double k2 = ((Kamera) o2).GetKaina();
//          // didėjanti tvarka, pradedant nuo mažiausios
//          if(k1<k2) return -1;
//          if(k1>k2) return 1;
//          return 0;
//       }
//    };
    
    public String validate() {
        String klaidosTipas = "";
        
        if (PagaminimoMetai < priimtinųMetųRiba || PagaminimoMetai > EsamiMetai) {
            klaidosTipas = "Netinkami gamybos metai, turi būti ["
                    + priimtinųMetųRiba + ":" + EsamiMetai + "]";
        }
        if (Kaina < MinKaina || Kaina > MaxKaina) {
            klaidosTipas += " Kaina už leistinų ribų [" + MinKaina
                    + ":" + MaxKaina + "]";
        }
        
        return klaidosTipas;
    }
    @Override
    public String toString(){  // surenkama visa reikalinga informacija
        String s = "";
        if (ArNaudota) s = "naudota";
        else s = "Nenaudota";
        return String.format("%-8s %-12s %4d %10s %8.2f %s",
               Gamintojas, Modelis, PagaminimoMetai, s, Kaina, validate());
    }
//        public int compareTo(Kamera a) { 
//        // lyginame pagal svarbiausią požymį - kainą
//        double kainaKita = a.GetKaina();
//        if (Kaina < kainaKita) return -1;
//        if (Kaina > kainaKita) return +1;
//        return 0;
//    };
//          
        
}