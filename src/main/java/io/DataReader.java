package io;

import java.util.Scanner;

public class DataReader {

    private final Scanner scan = new Scanner(System.in);

    // Konstruktor do wstrzyknięcia obiektu printer

    public DataReader(ConsolePrinter printer) {
    }

    public int getInt() {
        try {
            return scan.nextInt();
        } finally {
            scan.nextLine();
        }
    }

    public double getDouble() {
        try {
            return scan.nextDouble();
        } finally {
            scan.nextLine();
        }
    }

    public void close() {
        scan.close();
    }

    // Method for load String

    public String getString() {
        return scan.nextLine();
    }
}

