package ArtikelVerwaltung;

public class Sorting {

    public static void IntSortNr(Artikel tmpList[],int n)
    {
        boolean sort;
        int i;
        Artikel tmpArtikel;

        do
        {
            sort=true;
            for(i=0; i<n-1;i++)
            {
                if(tmpList[i].get_Nummer()>tmpList[i+1].get_Nummer())
                {
                    tmpArtikel=tmpList[i];
                    tmpList[i]=tmpList[i+1];
                    tmpList[i+1]=tmpArtikel;
                    sort=false;
                }
            }
        }while(sort!=true);
    }

    public static void IntSortAnzahl(Artikel tmpList[],int n)
    {
        boolean sort;
        int i;
        Artikel tmpArtikel;

        do
        {
            sort=true;
            for(i=0; i<n-1;i++)
            {
                if(tmpList[i].get_Anzahl()>tmpList[i+1].get_Anzahl())
                {
                    tmpArtikel=tmpList[i];
                    tmpList[i]=tmpList[i+1];
                    tmpList[i+1]=tmpArtikel;
                    sort=false;
                }
            }
        }while(sort!=true);
    }

    public static void StringSortName(Artikel tmpList[], int n)
    {
        boolean sort;
        int i;
        Artikel tmpArtikel;

        do
        {
            sort=true;
            for(i=0; i<n-1;i++)
            {
                if(tmpList[i].get_Name().compareTo(tmpList[i+1].get_Name())>0)
                {
                    tmpArtikel=tmpList[i];
                    tmpList[i]=tmpList[i+1];
                    tmpList[i+1]=tmpArtikel;
                    sort=false;
                }
            }
        }while(sort!=true);

    }

    public static void DoubleSortPreis(Artikel tmpList[],int n)
    {
        boolean sort;
        int i;
        Artikel tmpArtikel;

        do
        {
            sort=true;
            for(i=0; i<n-1;i++)
            {
                if(tmpList[i].get_Preis()>tmpList[i+1].get_Preis())
                {
                    tmpArtikel=tmpList[i];
                    tmpList[i]=tmpList[i+1];
                    tmpList[i+1]=tmpArtikel;
                    sort=false;
                }
            }
        }while(sort!=true);
    }

}
