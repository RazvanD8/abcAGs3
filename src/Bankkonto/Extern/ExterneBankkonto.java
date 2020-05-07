package Bankkonto.Extern;

import ArtikelVerwaltung.Artikel;
import javafx.scene.input.DataFormat;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.*;

public class ExterneBankkonto
{
    public static void main(String[] args) throws IOException {
        /* Variablendeklaration */
        byte opt1;
        byte opt2;
        double betrag;
        boolean ok;
        String tmpString;
        int n;
        int i;
        int j;
        int k;
        int l;

        double umsnr;
        double ums;
        double aks;
        double nks;
        double aktuell;

        n=0;
        String tmpAks;
        String tmpUms;
        String tmpNks;
        String tmpUmsnr;

        /* Instanz bilden */
        ExterneGiroKonto MeinGiro = new ExterneGiroKonto(-5000, 12.5f, 1.0f);
        ExterneSparKonto MeinSpar = new ExterneSparKonto(1.5f);

        ExterneGiroKonto SeinGiro = new ExterneGiroKonto(-5000, 8.25f, 2.5f);


        Scanner scan = new Scanner(System.in);
        /* Array vom Typ Umsatze anlegen */
        Umsatze[] umList = new Umsatze[100];

        /* Einlesen */
        FileReader fr = new FileReader("ExterneBankkonto.txt");
        BufferedReader br = new BufferedReader(fr);

        tmpString = br.readLine();
        n = parseInt(tmpString);

        for (int index = 0; index < n; index++) {

            tmpString = br.readLine();
            i = tmpString.indexOf(" ");
            tmpUmsnr = tmpString.substring(0, i);
            umsnr = Double.parseDouble(tmpUmsnr);

            j = tmpString.indexOf(" ", i + 1);
            tmpUms = tmpString.substring(i + 1, j);
            ums = Double.parseDouble(tmpUms);

            k = tmpString.indexOf(" ", j + 1);
            tmpAks = tmpString.substring(j + 1, k);
            aks = Double.parseDouble(tmpAks);

            l = tmpString.length();
            tmpNks = tmpString.substring(k + 1, l);
            nks = Double.parseDouble(tmpNks);


            Umsatze tmpUmsatz = new Umsatze(umsnr, ums, aks, nks);
            umList[index] = tmpUmsatz;

        }

        br.close();
        fr.close();
        /* Endlosschleife */
        for (; ; ) {
            System.out.print("\n Bankkonto");
            System.out.print("\n =========");
            System.out.print("\n 1 - Kontoübersicht");
            System.out.print("\n 2 - Einzahlung");
            System.out.print("\n 3 - Auszahlung");
            System.out.print("\n 4 - Umbuchung");
            System.out.print("\n 5 - Überweisung");
            System.out.print("\n 6 - Zinszahlung");
            System.out.print("\n 8 - Anzeigen");
            System.out.print("\n 0 - ENDE");
            System.out.print("\n Ihre Wahl: ");

            opt1 = scan.nextByte();

            switch (opt1) {
                case 1:
                    System.out.print("\n Kontoübersicht");
                    System.out.print("\n ==============");
                    System.out.print("\n 1 - Meine Konten");
                    System.out.print("\n 2 - Seine Konten");
                    System.out.print("\n Ihre Wahl: ");

                    opt2 = scan.nextByte();

                    switch (opt2) {
                        case 1:

                            System.out.print("\n Meine Konten");
                            System.out.print("\n ============");
                            System.out.printf("\n Girokonto: %8.2f €", MeinGiro.get_Kontostand());
                            System.out.printf("\n Sparkonto: %8.2f €", MeinSpar.get_Kontostand());
                            System.out.print("\n");
                            break;
                        case 2:
                            System.out.print("\n Seine Konten");
                            System.out.print("\n ============");
                            System.out.printf("\n Girokonto: %8.2f €", SeinGiro.get_Kontostand());
                            System.out.print("\n");
                            break;
                    }

                    break;

                case 2:
                    System.out.print("\n Einzahlung");
                    System.out.print("\n ==========");
                    System.out.print("\n Betrag (in €): ");
                    betrag = scan.nextDouble();
                    MeinGiro.Einzahlung(betrag);
                    System.out.print("\n");
                    break;

                case 3:
                    System.out.print("\n Auszahlung");
                    System.out.print("\n ==========");
                    System.out.print("\n Betrag (in €): ");
                    betrag = scan.nextDouble();
                    ok = MeinGiro.Auszahlung(betrag);
                    if (!ok)
                        System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €", MeinGiro.get_Kontostand() - MeinGiro.get_Limit());
                    System.out.print("\n");
                    break;

                case 4:
                    System.out.print("\n Umbuchung");
                    System.out.print("\n =========");
                    System.out.print("\n 1 - vom Girokonto auf das Sparkonto");
                    System.out.print("\n 2 - vom Sparkonto auf das Girokonto");
                    System.out.print("\n Ihre Wahl: ");

                    opt2 = scan.nextByte();

                    switch (opt2) {
                        case 1:
                            System.out.print("\n Girokonto ==> Sparkonto");
                            System.out.print("\n");
                            System.out.print("\n Betrag (in €): ");
                            betrag = scan.nextDouble();

                            ok = MeinGiro.Auszahlung(betrag);

                            if (!ok)
                                System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €", MeinGiro.get_Kontostand() - MeinGiro.get_Limit());
                            else
                                MeinSpar.Einzahlung(betrag);

                            System.out.print("\n");
                            break;
                        case 2:
                            System.out.print("\n Sparkonto ==> Girokonto");
                            System.out.print("\n");
                            System.out.print("\n Betrag (in €): ");
                            betrag = scan.nextDouble();

                            ok = MeinSpar.Auszahlung(betrag);

                            if (!ok)
                                System.out.printf("\n Keine ausreichende Kontodeckung vorhanden! Noch verfügbar: %.2f €", MeinSpar.get_Kontostand());
                            else
                                MeinGiro.Einzahlung(betrag);

                            System.out.print("\n");
                            break;
                    }

                    break;

                case 5:
                    System.out.print("\n Überweisung");
                    System.out.print("\n ===========");
                    System.out.print("\n Betrag (in €): ");

                    betrag = scan.nextDouble();
                    ok = MeinGiro.Auszahlung(betrag);

                    if (!ok)
                        System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €", MeinGiro.get_Kontostand() - MeinGiro.get_Limit());
                    else
                        SeinGiro.Einzahlung(betrag);

                    System.out.print("\n");
                    break;

                case 6:

                    MeinGiro.Zinszahlung();
                    MeinSpar.Zinszahlung();
                    SeinGiro.Zinszahlung();

                    System.out.print("\n Zinszahlungen sind erfolgt!");
                    System.out.print("\n");

                    break;

                case 8:
                    System.out.print("\n Nr. Kontostand   Umsatz  AktuelleKontostand          Datum ");
                    System.out.print("\n ------------------------------------------------------------------");



                    for (i = 0; i < n; i++)
                    {
                        System.out.printf("\n %.0f ", umList[i].get_umsatznummer());
                        System.out.printf(" %8.2f €   -", umList[i].get_altekontostand());
                        System.out.printf(" %6.2f €", umList[i].get_umsatz());
                        System.out.printf(" %11.2f €    ", umList[i].get_neuekontostand());
                        Date now = new Date();
                        System.out.printf(String.valueOf(now));


                    }

                    System.out.print("\n ------------------------------------------------------------------");
                    System.out.printf("\n Sie Haben :                70 €");
                    System.out.print("\n");

                    break;


                }
            if (opt1 == 0) break;
        }
        /* Speichern */
        FileWriter fw = new FileWriter("ExterneBankkonto.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(n + "\n");

        for (i = 0; i < n; i++)
            bw.write(umList[i].get_umsatznummer() + " " + umList[i].get_altekontostand() + " " + umList[i].get_umsatz() + " " + umList[i].get_neuekontostand() + "\n");


        bw.close();
        fw.close();


    }
}
