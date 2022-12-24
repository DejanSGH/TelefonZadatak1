import java.util.ArrayList;

public class Korisnik implements Cloneable {

    private Broj brojKorisnika;
    private int brojUsluga;
    private ArrayList<String> vrsteUsluga;

    private ArrayList<Poziv> evidencijaPoziva;
    private ArrayList<Poruka> evidencijaPoruka;
    public Korisnik(Broj brojKorisnika, int brojUsluga) {
        this.brojKorisnika = brojKorisnika;
        this.brojUsluga = brojUsluga;
        this.evidencijaPoziva = new ArrayList<Poziv>();
        this.evidencijaPoruka = new ArrayList<Poruka>();
        this.vrsteUsluga = new ArrayList<String>();
    }

    public void pozovi(Broj brojKojiPoziva, int trajanjePoziva){
        Poziv poziv = new Poziv(brojKorisnika, brojKojiPoziva, trajanjePoziva);

        if(brojKojiPoziva == this.brojKorisnika){
            System.out.println("Pozivate sopstveni broj, poziv nije evidentiran");
        }
        brojUsluga++;
        evidencijaPoziva.add(poziv);
        vrsteUsluga.add("Redni broj usluge: " + brojUsluga  + " Vrsta usluge: Poziv");
    }

    public void posaljiPoruku(Broj brojKaKojemSeSaljePoruka, String sadrzajPoruke){
        Poruka poruka = new Poruka(brojKorisnika, brojKaKojemSeSaljePoruka, sadrzajPoruke);
        brojUsluga++;
        evidencijaPoruka.add(poruka);
        vrsteUsluga.add("Redni broj usluge: " + brojUsluga  + " Vrsta usluge: Poruka");
    }



    public void brojUsluga(){
        System.out.println(this.brojUsluga);
    }

    public void evidencijaPoziva(){
        for (int i = 0; i < evidencijaPoziva.size(); i++) {
            evidencijaPoziva.get(i).toString();
            System.out.println(evidencijaPoziva.get(i).cenaUsluge);
        }
    }
    public void evidencijaPoruka(){
        for (int i = 0; i < evidencijaPoruka.size(); i++) {
            evidencijaPoruka.get(i).toString();
            System.out.println(evidencijaPoruka.get(i).cenaUsluge);
        }
    }
    public void evidencijaUsluga(){
        for (int i = 0; i < vrsteUsluga.size(); i++) {
            System.out.println(vrsteUsluga.get(i));
        }
        System.out.println("Ukupan broj svih usluga: " + this.brojUsluga);
    }

    public Korisnik clone(){
        Korisnik novi = new Korisnik(this.brojKorisnika.clone(), this.brojUsluga);
        for (Poziv p : this.evidencijaPoziva) {
            //Poziv n = p.clone();
            novi.evidencijaPoziva.add(p.clone());
        }
        novi.evidencijaPoruka = this.evidencijaPoruka;

        return novi;
    }
}
