public class Poziv extends Usluga {

    private int trajanjePoziva;
    private int brojMinuta;
    private int ostatakSekundi;
    private String zM;
    private String zS;
    private String obavestenje;

    public Poziv(Broj broj_od, Broj broj_ka, int trajanjePoziva) {
        super(broj_od, broj_ka);
        this.trajanjePoziva = trajanjePoziva;
        this.ostatakSekundi = trajanjePoziva % 60;
        this.brojMinuta = trajanjePoziva / 60;
        if(brojMinuta < 9){
            zM = "0";
        }
        else {
            zM = "";
        }
        if(ostatakSekundi < 9){
            zS = "0";
        }
        else {
            zS = "";
        }
        //definisanjCeneUsluge();

    }


    @Override
    public int definisanjCeneUsluge() {
        Broj b1 = broj_od;
        Broj b2 = broj_ka;
        if(Broj.isSameState(b1, b2)){
            this.cenaUsluge = (this.brojMinuta - 1) * 10;
            if(this.ostatakSekundi > 0){
                this.cenaUsluge += 10;
            }
            System.out.println("Trajanje poziva:\n" + zM + brojMinuta + ":" + zS + ostatakSekundi);
            System.out.println("Cena poziva u dinarima iznosi:");
            return (int)this.cenaUsluge;
        }
        if(trajanjePoziva <= 0){
            System.out.println("Poziv nije uspostavljen");
            System.out.println("Trajanje poziva:\n" + zM + brojMinuta + ":" + zS + ostatakSekundi);
            System.out.println("Cena poziva u dinarima iznosi:");
            return 0;
        }
        else
        {
            this.cenaUsluge = (this.brojMinuta - 1) * 50 + 30;
            if(this.ostatakSekundi > 0 && this.brojMinuta > 0){
                this.cenaUsluge += 50;
            }
            System.out.println("Trajanje poziva:\n" + zM + brojMinuta + ":" + zS + ostatakSekundi);
            System.out.println("Cena poziva u dinarima iznosi:");
            return (int)this.cenaUsluge;
        }
    }

    public String toString(){
        return "" + definisanjCeneUsluge();
    }

}
