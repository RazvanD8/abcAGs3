package Bankkonto.Intern;

import java.util.Scanner;

public class InterneBankkonto
{
    public static void main(String[] args)
{
    /* Variablendeklaration */
    byte opt1;
    byte opt2;
    double betrag;
    boolean ok;

    /* Instanz bilden */
    InterneGiroKonto MeinGiro = new InterneGiroKonto(-1000, 12.5f, 1.0f);
    InterneSparKonto MeinSpar = new InterneSparKonto(1.5f);

    InterneGiroKonto SeinGiro = new InterneGiroKonto(-2000,8.25f,2.5f);

    Scanner scan = new Scanner(System.in);

    /* Endlosschleife */
    for(;;)
    {
        System.out.print("\n Bankkonto");
        System.out.print("\n =========");
        System.out.print("\n 1 - Kontoübersicht");
        System.out.print("\n 2 - Einzahlung");
        System.out.print("\n 3 - Auszahlung");
        System.out.print("\n 4 - Umbuchung");
        System.out.print("\n 5 - Überweisung");
        System.out.print("\n 6 - Zinszahlung");
        System.out.print("\n 0 - ENDE");
        System.out.print("\n Ihre Wahl? ");

        opt1 = scan.nextByte();

        switch(opt1)
        {
            case 1:
                System.out.print("\n Kontoübersicht");
                System.out.print("\n ==============");
                System.out.print("\n 1 - Meine Konten");
                System.out.print("\n 2 - Seine Konten");
                System.out.print("\n Ihre Wahl: ");

                opt2=scan.nextByte();

                switch(opt2)
                {
                    case 1:
                        System.out.print("\n Meine Konten");
                        System.out.print("\n ============");
                        System.out.printf("\n Girokonto: %8.2f €",MeinGiro.get_Kontostand());
                        System.out.printf("\n Sparkonto: %8.2f €",MeinSpar.get_Kontostand());
                        System.out.print("\n");
                        break;
                    case 2:
                        System.out.print("\n Seine Konten");
                        System.out.print("\n ============");
                        System.out.printf("\n Girokonto: %8.2f €",SeinGiro.get_Kontostand());
                        System.out.print("\n");
                        break;
                }

                break;

            case 2:
                System.out.print("\n Einzahlung");
                System.out.print("\n ==========");
                System.out.print("\n Betrag (in €): ");
                betrag=scan.nextDouble();
                MeinGiro.Einzahlung(betrag);
                System.out.print("\n");
                break;

            case 3:
                System.out.print("\n Auszahlung");
                System.out.print("\n ==========");
                System.out.print("\n Betrag (in €): ");
                betrag=scan.nextDouble();
                ok = MeinGiro.Auszahlung(betrag);
                if(ok==false)
                System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €",MeinGiro.get_Kontostand()-MeinGiro.get_Limit());
                System.out.print("\n");
                break;

            case 4:
                System.out.print("\n Umbuchung");
                System.out.print("\n =========");
                System.out.print("\n 1 - vom Girokonto auf das Sparkonto");
                System.out.print("\n 2 - vom Sparkonto auf das Girokonto");
                System.out.print("\n Ihre Wahl? ");

                opt2=scan.nextByte();

                switch(opt2)
                {
                    case 1:
                        System.out.print("\n Girokonto ==> Sparkonto");
                        System.out.print("\n");
                        System.out.print("\n Betrag (in €): ");
                        betrag=scan.nextDouble();

                        ok = MeinGiro.Auszahlung(betrag);

                        if(ok==false)
                            System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €",MeinGiro.get_Kontostand()-MeinGiro.get_Limit());
                        else
                            MeinSpar.Einzahlung(betrag);

                        System.out.print("\n");
                        break;
                    case 2:
                        System.out.print("\n Sparkonto ==> Girokonto");
                        System.out.print("\n");
                        System.out.print("\n Betrag (in €): ");
                        betrag=scan.nextDouble();

                        ok = MeinSpar.Auszahlung(betrag);

                        if(ok==false)
                            System.out.printf("\n Keine ausreichende Kontodeckung vorhanden! Noch verfügbar: %.2f €",MeinSpar.get_Kontostand());
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

                betrag=scan.nextDouble();
                ok = MeinGiro.Auszahlung(betrag);

                if(ok==false)
                    System.out.printf("\n Limit erreicht! Noch verfügbar: %.2f €",MeinGiro.get_Kontostand()-MeinGiro.get_Limit());
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
        }

        if(opt1==0) break;
    }

}

}
