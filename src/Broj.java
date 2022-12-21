public class Broj {

    String kodDrzave;
    private String pozivniBroj;
    private String brojTelefona;

    boolean fiksniTelefon = true;
    private boolean porukaPoslata = true;

    public Broj(String kodDrzave, String pozivniBroj, String brojTelefona) {

        this.kodDrzave = kodDrzave;
        this.pozivniBroj = pozivniBroj;
        this.brojTelefona = brojTelefona;

        if(pozivniBroj.charAt(1) == '6'){
            this.fiksniTelefon = false;
        }

    }

    public Broj(String nl) throws LosFormatBrojaIzuzetak {
        String[] delovi = nl.split("-");
        if(losFormatBroja(delovi)) throw new LosFormatBrojaIzuzetak();

        this.kodDrzave = delovi[0];
        this.pozivniBroj = delovi[1];
        this.brojTelefona = delovi[2];

        if(pozivniBroj.charAt(1) == '6'){
            this.fiksniTelefon = false;
        }
    }

    private boolean losFormatBroja(String[] delovi) {
        if(delovi.length < 3){
            return true;
        }
        return false;
    }

    public boolean isFiksniTelefon() {
        return fiksniTelefon;
    }

    public String toString(){

        return "+" + kodDrzave + pozivniBroj + brojTelefona;
    }

    public static boolean isSameState(Broj b1, Broj b2){
        if(b1.kodDrzave.equals(b2.kodDrzave)){
            return true;
        }
        return false;
    }

    public static boolean isSMSSendOrRecivedByFiksni(Broj b1, Broj b2){
        if(b1.isFiksniTelefon() || b2.isFiksniTelefon()){
            return true;
        }
        return false;
    }

}
