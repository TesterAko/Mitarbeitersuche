package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SearchEmployeeTest {

    @Test
    public void testSearchEmployee() throws FileNotFoundException {
        // Hier können Sie die searchEmployee-Methode aufrufen und die Ausgaben überprüfen
        // Erstellen Sie dazu ein Main-Objekt oder verwenden Sie eine andere Methode, um die Methode zu testen.
        // Vergleichen Sie die tatsächlichen Ergebnisse mit den erwarteten Ergebnissen mithilfe von Assertions.

        Main main = new Main(); // Erstellen Sie ein Main-Objekt

        // Annahme: Hier sollte ein Mitarbeiter mit dem Namen "Jonas" gefunden werden
        String expectedName = "Jonas";
        // Rufen Sie die Methode auf und speichern Sie das Ergebnis
        String actualName = main.searchEmployee("Jonas");

        // Überprüfen Sie, ob das tatsächliche Ergebnis mit dem erwarteten Ergebnis übereinstimmt
        Assert.assertEquals(expectedName, actualName);
    }
}






        /*Führen Sie die Tests aus:

        Verwenden Sie Ihre IDE oder Ihr Build-Tool, um die JUnit-Tests auszuführen.
        Die Tests sollten die in Ihren Testfällen definierten Assertions überprüfen und Ihnen mitteilen, ob Ihre Funktionen wie erwartet funktionieren.
        Wiederholen Sie diese Schritte für andere Methoden, die Sie testen möchten.

        Es ist wichtig zu beachten, dass Ihre Klassen und Methoden für den Test zugänglich sein sollten. Sie können dies erreichen, indem Sie die Sichtbarkeit von Klassen oder Methoden entsprechend ändern oder Getter-Methoden hinzufügen, wenn dies erforderlich ist.

        Denken Sie daran, dass Unit-Tests dazu beitragen, die Qualität Ihres Codes sicherzustellen und mögliche Fehler frühzeitig zu erkennen. Sie sollten verschiedene Szenarien testen, einschließlich derer, die zu Fehlern führen könnten, und sicherstellen, dass Ihre Funktionen korrekt reagieren.
*/





