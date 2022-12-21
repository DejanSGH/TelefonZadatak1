public class PogresanFormatNazivaImenikaIzuzetak extends Exception {

  private String nazivFajla;

    public PogresanFormatNazivaImenikaIzuzetak(String nazivFajla) {
        this.nazivFajla = nazivFajla;
    }

    public String toString(){
        return "Pogresan format za imenik: " + nazivFajla;
    }
}
