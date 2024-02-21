/*
package danewpliku;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DaneWPliku {

    public static void main(String[] args) {
        // Nazwa pliku do którego zapiszemy i z którego odczytamy tekst
        String nazwaPliku = "dane.csv";
        // Tablica z danymi - 3 serie w rzędach po 5 liczb (np. pomiarów)
        double[][] dane = {{2.3, 2.2, 2.1, 2.0, 1.8},
                {2.2, 2.1, 2.1, 2.3, 2.0},
                {2.2, 2.2, 2.1, 1.9, 1.8}
        };

        // Zapis pliku
        zapiszPlik(nazwaPliku, dane);
        // Odczyt pliku i konwersja do tablicy
        double[][] odczyt = odczytajPlik(nazwaPliku);
        // Coś robimy z odczytanymi danymi
        obliczenia(odczyt);
    }

    // Metoda zapisuje tekst w pliku tekstowym
    public static void zapiszPlik(String nazwaPliku, double[][] dane) {

        // Tworzymy obiekt typu Path
        Path sciezka = Paths.get(nazwaPliku);
        ArrayList out = new ArrayList();

        // Pobranie kolejnego "rzędu" danych
        for (double[] seria : dane) {
            String s = Arrays.toString(seria);
            // Arrays.toString(seria) zwraca dane w postaci:
            // [2.3, 2.2, 2.1, 2.0, 1.8]
            // trzeba usunąć znaki [ i ]
            s = s.replace("[", "");
            s = s.replace("]", "");
            // dodanie linijki z danymi do listy
            out.add(s);
        }
        try {
            Files.write(sciezka, out);
        } catch (IOException ex) {
            System.out.println("Nie mogę zapisać pliku!");
        }
    }

    // Metoda odczytuje tekst z pliku tekstowego,
    public static double[][] odczytajPlik(String nazwaPliku) {
        // Tworzymy obiekt typu Path
        Path sciezka = Paths.get(nazwaPliku);
        // Lista będzie przechowywała kolejne linie odczytane z pliku jako String
        ArrayList odczyt = new ArrayList();
        try {
            // Od razu odczytane zostają wszystkie linie pliku
            // i umieszczone w liście
            odczyt = (ArrayList) Files.readAllLines(sciezka);
        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }

        // Teraz trzeba łańcuchy znaków dla każdej linii przekonwertować
        // na dane liczbowe i umieścić je w tablicy

        // Tablica dla odczytanych danych
        // Na razie wiemy tylko ile będzie "rzędów"
        double[][] daneOdczytane = new double[odczyt.size()][];
        // Będziemy potrzebowali indeksu linii
        int nrLinii = 0;
        // Pobranie kolejnych linii z listy
        for (String linia : odczyt) {
            // Rozbijamy linię na poszczególne linie (przedzielone przecinkami)
            String[] liniaDaneString = linia.split(",");
            // Tablica do przechowania danych w fomie liczb double
            double[] liniaDouble = new double[liniaDaneString.length];
            // Pętla, która pobiera z tablicy String-ów po jednej liczbie,
            // konwertuje ją na liczbę double i zapisuje w tablicy typu double[]
            for (int i = 0; i &lt; liniaDouble.length; i++) {
                liniaDouble[i] = Double.parseDouble(liniaDaneString[i]);
            }
            // Dodajemy tablicę z serią danych do tablicy z wszystkimi danymi
            daneOdczytane[nrLinii] = liniaDouble;
            // kolejna linia...
            nrLinii++;
        }
        return daneOdczytane;
    }

    // Robimy coś z danymi
    public static void obliczenia(double[][] dane) {
        double suma = 0.0;
        // Pobranie kolejnej serii danych
        for (double[] rzad : dane) {
            // pobranie kolejnej danej i dodanie do sumy
            for (double dana : rzad) {
                suma += dana;
            }
            // Wydruk danych, sumy i średniej dla serii
            System.out.println("Dane: " + Arrays.toString(rzad)
                    + " suma: " + suma
                    + " średnia: " + suma / rzad.length);
        }

    }
}

 */
