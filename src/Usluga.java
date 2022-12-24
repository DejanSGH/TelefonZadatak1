public abstract class Usluga implements Cloneable {

    protected boolean isPorukaPoslata;
    protected Broj broj_od;
   protected Broj broj_ka;

   protected double cenaUsluge;

   private static int ukupnoUsluga = 0;

    public Usluga(Broj broj_od, Broj broj_ka) {
        ukupnoUsluga++;
        this.broj_od = broj_od;
        this.broj_ka = broj_ka;
    }

    public String toString(){
        return broj_od + " --> " + broj_ka;
    }

    public int getCenaUsluge() {
        return (int)cenaUsluge;
    }

    public abstract int definisanjCeneUsluge();

    public abstract Usluga clone();

}
