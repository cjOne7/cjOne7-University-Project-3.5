package therapy;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import table.AbstrTable;
import table.Table;
import table.TypProhlidky;
import therapistData.Surname;
import therapistData.Therapist;

public class SpravaTerapeutu implements Sprava {

    private Table<String, Therapist> abstrTable = new AbstrTable();
    
    @Override
    public void vlozTerapeuta(final Therapist therapist) {
        abstrTable.vloz(therapist.getPerson().getSurname().toString(), therapist);
    }

    @Override
    public Therapist najdi(final Surname key) {
        return abstrTable.najdi(key.toString());
    }

    @Override
    public Therapist odeber(final Surname key) {
        try {
            return abstrTable.odeber(key.toString());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SpravaTerapeutu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void zrus() {
        abstrTable.zrus();
    }

    @Override
    public Iterator<Therapist> VytvorIterator(final TypProhlidky typ) {
        return abstrTable.vytvorIterator(typ);
    }

    public Table<String, Therapist> getAbstrTable() {
        return abstrTable;
    }
}
