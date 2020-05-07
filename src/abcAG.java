import ArtikelVerwaltung.*;
import Bankkonto.Extern.*;

import java.io.IOException;
import java.util.Scanner;


public class abcAG
{
    public static void main(String[] args) {

        byte opt;

        Scanner scan = new Scanner(System.in);

        for(;;)
            {
            System.out.print("\n    --- ABC.AG ---");
            System.out.print("\n ======================");
            System.out.print("\n");
            System.out.print("\n 1 - Artikelverwaltung");
            System.out.print("\n 2 - Bankkonto");
            System.out.print("\n 3 - Statistics");
            System.out.print("\n 0 - ENDE");
            System.out.print("\n Ihre Wahl: ");
            opt = scan.nextByte();
                switch (opt)
                {

                    case 1:

                        try {
                            artikelVerwaltung.main(args);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            ExterneBankkonto.main(args);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                    if(opt == 0)
                        break;

            }

    }
}
