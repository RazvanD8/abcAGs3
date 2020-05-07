package Bankkonto.Extern;

public class ExterneGiroKonto extends ExterneKonto
{
    /* Membervariablen */
    private double mLimit;
    private float mSollzins;

    /* Konstruktor */
    public ExterneGiroKonto(double limit, float s_zins, float h_zins)
    {
        super(h_zins);
        mLimit = limit;
        mSollzins=s_zins;
    }

    /* Methoden */
    public double get_Limit()
    {
        return mLimit;
    }

    public float get_Sollzins()
    {
        return mSollzins;
    }

    public void set_Limit(double betrag)
    {
        mLimit=betrag;
    }

    public void set_Sollzins(float zins)
    {
        mSollzins = zins;
    }

    public boolean Auszahlung(double betrag)
    {
        /* Variablendeklaration */
        boolean ok;

        /* Auszahlung tätigen */
        if(mKontostand-betrag<mLimit)
        {
            ok=false;
        }
        else
        {
            mKontostand = mKontostand - betrag;
            ok=true;
        }

        /* Rückgabewert abschicken */
        return ok;
    }

    @Override public void Zinszahlung()
    {
        double zinsen;

        if(mKontostand<0)
            zinsen = mKontostand * mSollzins /100;
        else
            zinsen = mKontostand * mHabenzins /100;

        mKontostand = mKontostand + zinsen;

    }

}

