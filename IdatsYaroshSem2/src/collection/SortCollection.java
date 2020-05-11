package collection;

import therapy.Term;

public class SortCollection {

    public static void sortCollection(final DoubleList<Term> abstrDoubleList) {
        final Object[] arrayOfTerms = abstrDoubleList.stream().toArray();
        for (int i = 1; i < arrayOfTerms.length - 1; i++) {
            for (int j = 0; j < arrayOfTerms.length - 1; j++) {
                final Term term = (Term) arrayOfTerms[j];
                final Term term1 = (Term) arrayOfTerms[j + 1];
                final int day1 = term.getStart().getDayOfYear();
                final int day2 = term1.getStart().getDayOfYear();
                if (day1 > day2) {
                    swap(arrayOfTerms, j);
                } else if (day1 == day2) {
                    final int hour1 = term.getStart().getHour();
                    final int hour2 = term1.getStart().getHour();
                    if (hour1 > hour2) {
                        swap(arrayOfTerms, j);
                    }
                }
            }
        }
        abstrDoubleList.zrus();
        for (Object arrayOfTerm : arrayOfTerms) {
            abstrDoubleList.vlozPosledni((Term) arrayOfTerm);
        }
    }

    private static void swap(final Object[] arrayOfTerms, final int j) {
        final Term temp = (Term) arrayOfTerms[j];
        arrayOfTerms[j] = arrayOfTerms[j + 1];
        arrayOfTerms[j + 1] = temp;
    }
}
