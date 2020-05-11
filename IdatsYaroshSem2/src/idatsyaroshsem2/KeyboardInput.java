package idatsyaroshsem2;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import table.AbstrTable;
import table.TypProhlidky;
import therapistData.Person;
import therapistData.Surname;
import therapistData.Therapist;
import therapistData.WorkHours;

public class KeyboardInput {

    public static void main(String[] args) {
        final AbstrTable<String, Therapist> abstrTable = new AbstrTable();
        final Scanner input = new Scanner(System.in);

        while (true) {
            final int choose = generateCLnumber("Choose the command from offered list:\n\t"
                    + "1 --> create a new therapist\n\t"
                    + "2 --> find a therapist by key\n\t"
                    + "3 --> delete a therapist by key\n\t"
                    + "4 --> clear all\n\t"
                    + "5 --> type all\n\t"
                    + "0 --> exit\n", 5);

            switch (choose) {
                case 1:
                    createTherapist(abstrTable);
                    break;
                case 2:
                    if (abstrTable.jePrazdny()) {
                        checkForEmpty(abstrTable);
                    } else {
                        System.out.println("Enter surname of required thearpist: ");
                        final String key = input.nextLine();
                        final Therapist therapist = abstrTable.najdi(key.trim().toLowerCase());
                        checkAndOutput(therapist, key);
                    }
                    break;
                case 3:
                    try {
                        if (abstrTable.jePrazdny()) {
                            checkForEmpty(abstrTable);
                        } else {
                            System.out.println("Enter surname of required thearpist: ");
                            final String key = input.nextLine();
                            final Therapist therapist = abstrTable.odeber(key.trim().toLowerCase());
                            checkAndOutput(therapist, key);
                        }
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(KeyboardInput.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                    abstrTable.zrus();
                    System.out.println("List is empty.");
                    break;
                case 5:
                    if (abstrTable.jePrazdny()) {
                        checkForEmpty(abstrTable);
                    } else {
                        final int browsingType = generateCLnumber(
                                "Please, choose the number from offered list:\n\t"
                                + "1 --> traverse therapist list by in-order type\n\t"
                                + "2 --> traverse therapist list by level-order type", 2);
                        switch (browsingType) {
                            case 1:
                                iteratorOutput(abstrTable, TypProhlidky.IN_ORDER);
                                break;
                            case 2:
                                iteratorOutput(abstrTable, TypProhlidky.LEVEL_ORDER);
                                break;
                            default:
                                System.out.println("Unknown command. Choose number from offered list.\n"
                                        + "Your choice is " + browsingType + "\n");
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command. Choose number from offered list.\n"
                            + "Your choice is " + choose + "\n");
            }
        }
    }

    private static int generateCLnumber(final String comment, final int topBorder) {
        System.out.println(comment);
        final Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Wrong number format.");
                input.nextLine();
            }
            System.out.print("Please, enter the number again from specified interval[0;" + topBorder + "]");
        }
    }

    private static void checkForEmpty(final AbstrTable<String, Therapist> abstrTable) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Sorry, but your list is empty. "
                + "Do you want to create a new record? Y/N");
        final String answer = input.nextLine();
        switch (answer.trim().toLowerCase()) {
            case "y":
                createTherapist(abstrTable);
                break;
            case "n":
                break;
            default:
                System.out.println("Unknown answer. Choose a letter from offered list.\n"
                        + "Your choice is " + answer + "\n");
                break;
        }
    }

    private static void checkAndOutput(final Therapist therapist, final String key) {
        if (therapist == null) {
            System.out.println("Therapist with " + key + " surname does not exist.");
        } else {
            System.out.println("Required therapist: " + therapist.toMyOwnString());
        }
    }

    private static void iteratorOutput(
            final AbstrTable<String, Therapist> abstrTable,
            final TypProhlidky typProhlidky) {
        final Iterator<Therapist> it = abstrTable.vytvorIterator(typProhlidky);
        while (it.hasNext()) {
            System.out.println(it.next().toMyOwnString());
        }
    }

    private static void createTherapist(final AbstrTable<String, Therapist> abstrTable) {
        final Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        final String name = input.nextLine();
        System.out.println("Enter surname: ");
        final String surname = input.nextLine();
        final Surname secondName = new Surname(surname);

        final Person person = new Person(name, secondName);

        System.out.println("Enter working hour:\nStart: ");
        final int start = isInDayInterval(input.nextInt());
        System.out.println("End: ");
        final int end = isInDayInterval(input.nextInt());

        final WorkHours workHours = new WorkHours(start, end);

        final Therapist therapist = new Therapist(person, workHours);
        abstrTable.vloz(therapist.getPerson().getSurname().toString(), therapist);
    }

    private static int isInDayInterval(int hour) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            if (hour >= 0 && hour < 24) {
                break;
            } else {
                System.err.println("Error! Invalid value. Enter new value from day interlval[0;23] for hour again!");
                hour = scanner.nextInt();
            }
        }
        return hour;
    }
}
