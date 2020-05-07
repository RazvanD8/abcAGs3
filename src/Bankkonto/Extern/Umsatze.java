package Bankkonto.Extern;

public class Umsatze {
    /* Instanzvariablen */

    private double altekontostand;
    private double umsatz;
    private double neuekontostand;
    private double umsatznummer;

    /* Konstruktor */
    public Umsatze(double umsnr ,double aks, double um, double nks )
    {
        umsatznummer = umsnr;
        altekontostand = aks;
        umsatz = um;
        neuekontostand = nks;

    }

    /* Getter-Methoden */

    public double get_umsatznummer()
    {
        return umsatznummer;
    }
    public double get_altekontostand()
    {

        return altekontostand;
    }
    public double get_umsatz()
    {
        return umsatz;
    }
    public double get_neuekontostand()
    {
        return neuekontostand;
    }

    public void set_altekontostand(double aks)
    {
        altekontostand = aks;
    }
    /* Setter-Methoden */

}
