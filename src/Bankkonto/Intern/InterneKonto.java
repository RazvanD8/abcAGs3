package Bankkonto.Intern;

public abstract class InterneKonto
{
    /* Membervariablen */
    protected double mKontostand;
    protected float mHabenzins;

    /* Konstruktor */
    public InterneKonto(float zins)
    {
        mKontostand = 0;
        mHabenzins = zins;
    }

    /* Methoden */
    public double get_Kontostand()
    {
        return mKontostand;
    }

    public float get_Habenzins()
    {
        return mHabenzins;
    }

    public void set_Habenzins(float zins)
    {
        mHabenzins = zins;
    }

    public void Einzahlung(double betrag)
    {
        mKontostand=mKontostand + betrag;
    }

    public void Zinszahlung()
    {
        double zinsen;

        zinsen = mKontostand*mHabenzins/100;

        mKontostand = mKontostand + zinsen;
    }

}

