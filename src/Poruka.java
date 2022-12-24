public class Poruka extends Usluga {

    private String sadrzajPoruke;
    private String ime = "test";

    public Poruka(Broj broj_od, Broj broj_ka, String sadrzajPoruke) {
        super(broj_od, broj_ka);
        this.sadrzajPoruke = sadrzajPoruke;
        //definisanjCeneUsluge();
    }

    @Override
    public int definisanjCeneUsluge() {
        Broj b1 = broj_od;
        Broj b2 = broj_ka;
        if(Broj.isSMSSendOrRecivedByFiksni(broj_od, broj_ka)){
            System.out.println("Nije moguce poslati poruku sa fiksnog telefona ili na fiksni telefon");
            System.out.println("Cena poruke u dinarima iznosi: ");
            this.cenaUsluge = 0;
            return (int)this.cenaUsluge;
        }
        else if(Broj.isSameState(broj_od, broj_ka)){
            System.out.println("Sadrzaj poruke: " + "'"+this.sadrzajPoruke+"'");
            System.out.println("Cena poruke u dinarima iznosi: ");
            this.cenaUsluge = 3;
            return (int)this.cenaUsluge;
        }
        System.out.println("Sadrzaj poruke: " + "'"+this.sadrzajPoruke+"'");
        System.out.println("Cena poruke u dinarima iznosi: ");
        this.cenaUsluge = 20;
        return (int)this.cenaUsluge;
    }

    @Override
    public String toString() {
        return "" + definisanjCeneUsluge();
//        return broj_od + " --> " + broj_ka + " \nsadrzaj poruke:\n '" + this.sadrzajPoruke + "'";
    }

    public Poruka clone(){
        return new Poruka(this.broj_od, this.broj_ka, this.sadrzajPoruke);
    }

}
