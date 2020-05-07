package Bankkonto.Extern;

public class ExterneSparKonto extends ExterneKonto
{
    /* Konstruktor */
    public ExterneSparKonto(float h_zins)
    {
        super(h_zins);
    }

    public boolean Auszahlung(double betrag)
    {
        /* Variablendeklaration */
        boolean ok;

        /* Auszahlung tätigen */
        if(mKontostand-betrag<0)
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

}
