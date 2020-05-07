package ArtikelVerwaltung;

public class Artikel
{
    /* Instanzvariablen */
    private int mNummer;
    private String mName;
    private int mAnzahl;
    private double mPreis;

    /* Konstruktor */
    public Artikel(int nr, String na, int anz, double pr)
    {
        mNummer = nr;
        mName = na;
        mAnzahl = anz;
        mPreis = pr;
    }

    /* Getter-Methoden */
    public int get_Nummer()
    {
        return mNummer;
    }

    public String get_Name()
    {
        return mName;
    }

    public int get_Anzahl()
    {
        return mAnzahl;
    }

    public double get_Preis()
    {
        return mPreis;
    }

    public double get_Lagerwert()
    {
        return mPreis*mAnzahl;
    }

    /* Setter-Methoden */
    public void set_Nummer(int nr)
    {
        mNummer=nr;
    }

    /* Methoden */
    public short sub_Anzahl(int anzahl)
    {
        short ok;

        if(mAnzahl>=anzahl)
        {
            mAnzahl = mAnzahl - anzahl;
            ok=0;
        }
        else
        {
            ok=-1;
        }

        return ok;
    }

    public void add_Anzahl(int anzahl)
    {
        mAnzahl = mAnzahl + anzahl;
    }

}
