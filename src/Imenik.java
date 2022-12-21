import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Imenik {
//test1
    private ArrayList<Broj> brojevi;
    private String nazivImenika;

    public Imenik(String nazivImenika) throws PogresanFormatNazivaImenikaIzuzetak {
        if(losFormat(nazivImenika)){
            throw new PogresanFormatNazivaImenikaIzuzetak(nazivImenika);
        }
        this.nazivImenika = nazivImenika;
        File file = new File(nazivImenika);
        try {
            Scanner s = new Scanner(file);
            brojevi = new ArrayList<Broj>();
            while(s.hasNextLine()){
                String nl = s.nextLine();
                try {
                    Broj b = new Broj(nl);
                    brojevi.add(b);
                } catch (LosFormatBrojaIzuzetak e) {
                    System.out.println("Los format: " + nl);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            throw new PogresanFormatNazivaImenikaIzuzetak(nazivImenika);
        }
    }

    private boolean losFormat(String naziv){
        if(!naziv.endsWith(".txt")){
            return true;
        }
        return false;
    }
}
