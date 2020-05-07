package ArtikelVerwaltung;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author fi
 */
@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class artikelVerwaltung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        /* Variablendeklaration */
        byte opt;
        int i;
        int j;
        int k;
        int l;
        int n;
        int nr;
        int anz;
        String na;

        String tmpString;
        String tmpNr;
        String tmpName;
        String tmpAnzahl;
        String tmpPreis;

        double pr;
        double gesamt;
        short ok;

        /* Initialisierung */
        n=0;

        /* Instanz bilden */
        Scanner scan = new Scanner(System.in);

        /* Array vom Typ Artikel anlegen */
        Artikel[] artList = new Artikel[100];

        /* Einlesen */
        FileReader fr = new FileReader("Artikel.txt");
        BufferedReader br = new BufferedReader(fr);

        tmpString=br.readLine();
        n = Integer.parseInt(tmpString);

        for(int index=0;index<n;index++)
        {
            tmpString=br.readLine();

            i = tmpString.indexOf(" ");
            tmpNr=tmpString.substring(0, i);
            nr=Integer.parseInt(tmpNr);

            j = tmpString.indexOf(" ", i+1);
            tmpName=tmpString.substring(i+1,j);
            na=tmpName;

            k = tmpString.indexOf(" ", j+1);
            tmpAnzahl=tmpString.substring(j+1, k);
            anz=Integer.parseInt(tmpAnzahl);

            l = tmpString.length();
            tmpPreis=tmpString.substring(k+1, l);
            pr=Double.parseDouble(tmpPreis);


            Artikel tmpArtikel = new Artikel(nr,na,anz,pr);
            artList[index]=tmpArtikel;
        }

        br.close();
        fr.close();

        /* Endlosschleife */
        for(;;)
        {
            System.out.print("\n Artikelverwaltung");
            System.out.print("\n =================");
            System.out.print("\n");
            System.out.print("\n 1 - Alle Artikel");
            System.out.print("\n 2 - Verkaufen");
            System.out.print("\n 3 - Einkaufen");
            System.out.print("\n 4 - Sortieren nach der Nummer");
            System.out.print("\n 5 - Sortieren nach dem Namen");
            System.out.print("\n 6 - Sortieren nach der Anzahl");
            System.out.print("\n 7 - Sortieren nach dem Preis");
            System.out.print("\n 8 - Neuer Artikel");
            System.out.print("\n 0 - ENDE");
            System.out.print("\n Ihre Wahl: ");

            opt = scan.nextByte();

            switch(opt)
            {
                case 1:
                    System.out.print("\n Nr. Artikel       Anzahl    Preis     Lagerwert");
                    System.out.print("\n -----------------------------------------------");

                    gesamt=0;

                    for(i=0;i<n;i++)
                    {
                        System.out.printf("\n %d",artList[i].get_Nummer());
                        System.out.printf(" %-15s",artList[i].get_Name());
                        System.out.printf(" %3d",artList[i].get_Anzahl());
                        System.out.printf("  %8.2f €",artList[i].get_Preis());
                        System.out.printf("  %8.2f €", artList[i].get_Lagerwert());
                        gesamt=gesamt+artList[i].get_Lagerwert();
                    }
                    System.out.print("\n -----------------------------------------------");
                    System.out.printf("\n Lagerwert: %10.2f €",gesamt);
                    System.out.print("\n");

                    break;

                case 2:
                    /* Überschrift */
                    System.out.print("\n Verkaufen");
                    System.out.print("\n =========");

                    /* Eingabe der gesuchten Artikelnummer */
                    System.out.print("\n Artikelnummer: ");
                    nr = scan.nextInt();

                    /* Artikel im Array suchen */
                    for(i=0;i<n;i++)
                    {
                        /* Artikel anhand seiner Artikelnummer ausfindig machen */
                        if(artList[i].get_Nummer()==nr)
                        {
                            /* Eingabe der Anzahl des zu verkaufenden Artikels */
                            System.out.print("\n Anzahl: ");
                            anz = scan.nextInt();

                            /* Verkauf im Objekt ausführen */
                            ok = artList[i].sub_Anzahl(anz);

                            /* Fehlerbehandlung */
                            if(ok==-1)
                            {
                                System.out.print("\n Das war zu viel!");
                                System.out.print("\n");
                            }

                            /* Suchschleife verlassen */
                            break;
                        }
                    }

                    break;

                case 3:
                    /* Überschrift */
                    System.out.print("\n Einkaufen");
                    System.out.print("\n =========");

                    /* Eingabe der gesuchten Artikelnummer */
                    System.out.print("\n Artikelnummer: ");
                    nr = scan.nextInt();

                    /* Artikel im Array suchen */
                    for(i=0;i<n;i++)
                    {
                        /* Artikel anhand seiner Artikelnummer ausfindig machen */
                        if(artList[i].get_Nummer()==nr)
                        {
                            /* Eingabe der Anzahl des zu verkaufenden Artikels */
                            System.out.print("\n Anzahl: ");
                            anz = scan.nextInt();

                            /* Einkauf im Objekt ausführen */
                            artList[i].add_Anzahl(anz);

                            /* Suchschleife verlassen */
                            break;
                        }
                    }
                    break;

                case 4:

                    /* Bubble-Sort (nach der Artikelnummer) */
                    Sorting.IntSortNr(artList, n);
                    break;

                case 5:
                    /* Bubble-Sort (nach dem Artikelnamen) */
                    Sorting.StringSortName(artList, n);
                    break;

                case 6:

                    /* Bubble-Sort (nach der Artikelanzahl) */
                    Sorting.IntSortAnzahl(artList, n);
                    break;

                case 7:

                    /* Bubble-Sort (nach dem Preis) */
                    Sorting.DoubleSortPreis(artList, n);
                    break;

                case 8:
                    /* Überschrift */
                    System.out.print("\n Neuer Artikel");
                    System.out.print("\n =============");

                    /* Eingabe der Artikelnummer */
                    System.out.print("\n Artikelnummer: ");
                    nr = scan.nextInt();

                    /* Eingabe des Artikelnamens */
                    System.out.print("\n Artikelname: ");
                    na = scan.next();

                    /* Eingabe der Anzahl */
                    System.out.print("\n Anzahl: ");
                    anz = scan.nextInt();

                    /* Eingabe des Preises */
                    System.out.print("\n Preis: ");
                    pr = scan.nextDouble();

                    /* Temporäres Objekt erzeugen */
                    Artikel tmpArtikels = new Artikel(nr,na,anz,pr);
                    artList[n]=tmpArtikels;

                    /* Objektzähler um eins erhöhen */
                    n++;

                    break;

            }

            if (opt==0) break;

        }

        /* Speichern */
        FileWriter fw = new FileWriter("Artikel.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(n + "\n");

        for(i=0; i <n; i++)
            bw.write(artList[i].get_Nummer()+" "+artList[i].get_Name() + " " + artList[i].get_Anzahl() + " " + artList[i].get_Preis() + "\n");


        bw.close();
        fw.close();

    }

}
