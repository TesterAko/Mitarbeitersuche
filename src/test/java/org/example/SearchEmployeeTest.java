package org.example;

import org.junit.Assert;//
/*org.junit.Assert: Hier wird die Klasse Assert aus dem Paket org.junit importiert.
Die Assert-Klasse enthält eine Reihe von statischen Methoden, die in JUnit-Tests häufig verwendet werden, um Assertions durchzuführen und Ergebnisse zu überprüfen.
Zum Beispiel verwenden Sie Assert.assertEquals(), um zu überprüfen, ob zwei Werte gleich sind.
Andere Methoden wie assertTrue(), assertFalse(), assertNotNull(), usw., stehen ebenfalls zur Verfügung,
um verschiedene Arten von Prüfungen durchzuführen.
 */
import org.junit.Test;

import java.io.FileNotFoundException;

public class SearchEmployeeTest {

    @Test
    public void testSearchEmployee() throws FileNotFoundException {
        // searchEmployee-Methode durchführen und die Ausgaben überprüfen

        Main main = new Main(); //Die zu testende Methode aus Main Methode holen


        String expectedName = "Jonas Meyer";
        // Annahme: Hier sollte ein Mitarbeiter mit dem Namen "Jonas" gefunden werden

        String actualName = main.searchEmployee("Jonas Meyer");
        // führe Methode durch und zeige aktuelles Ergebnis

        Assert.assertEquals(expectedName, actualName);
        //überprüfe ob beide Ergebnisse zusammenstimmen
    }
}








