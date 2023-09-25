package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IntroTest extends Main {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //private - Zugriffsspezifikator, der angibt, dass die Variable outContent nur innerhalb der aktuellen Klasse sichtbar und zugreifbar ist
        //PrintStream - Typ, der zur Ausgabe von Strings verwendet wird
        //final - Zugriffsspezifikator, der angibt, dass die Variable nicht mehr geändert werden soll
        // In diesem Fall wird outContent nach der Initialisierung nicht auf einen anderen Wert gesetzt.

        //Ein Byte-Array-Stream (ByteArrayOutputStream) ist eine Klasse in Java, die dazu verwendet wird, Daten in einen Byte-Array-Puffer zu schreiben
        // ByteArrayOutputStream ist eine Klasse in Java, die dazu verwendet wird, Daten in einen Byte-Array-Stream zu schreiben
        private final PrintStream originalOut = System.out;

        @BeforeEach
        void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        void restoreStreams() {
            System.setOut(originalOut);
        }

        @Test
        void testIntroOutput() {
            // Aufruf der Intro-Methode
            Main.intro();

            // Erfassen der Ausgabe in einem String
            String introOutput = outContent.toString().trim();// trim() - Methode, die den String auf den Anfang und Ende entfernt

            // Erwartete Ausgabe aus der Intro-Methode
            String expectedOutput = "Willkommen zum Mitarbeiterverwaltungssystem\n Log In";

            // Vergleichen Sie die erfasste Ausgabe mit der erwarteten Ausgabe
        assertNotEquals(expectedOutput, introOutput);
        }
    }