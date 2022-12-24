public class Main {

    public static void main(String[] args) {

        Broj broj = new Broj("381", "061", "123456");
        Broj broj1 = new Broj("381", "061", "654321");


        //Usluga poziv = new Poziv(broj, broj1, 133);
        //System.out.println(poziv.getCenaUsluge());

        //Usluga poruka = new Poruka(broj, broj1, "Poruka sa sadrzajem");
        //System.out.println(poruka.getCenaUsluge());

        Korisnik korisnik = new Korisnik(broj, 0);

        korisnik.pozovi(broj1, 133);
        korisnik.posaljiPoruku(broj1, "Poruka broj 1");
        korisnik.posaljiPoruku(broj1, "Poruka broj 2");
        korisnik.pozovi(broj1, 258);
        korisnik.pozovi(broj1, 17);
        korisnik.pozovi(broj1, 1742);
        korisnik.posaljiPoruku(broj1, "Poruka broj 3");
//        korisnik.brojUsluga();
//        korisnik.evidencijaPoziva();
//        korisnik.evidencijaPoruka();
//        korisnik.evidencijaUsluga();


    }
}
