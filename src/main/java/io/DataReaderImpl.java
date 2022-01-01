package io;

import java.util.Scanner;

public class DataReaderImpl implements DataReader {

    private final Scanner scan = new Scanner(System.in);

    @Override
    public int getInt() {
        try {
            return scan.nextInt();
        } finally {
            scan.nextLine();
        }
    }

    @Override
    public double getDouble() {
        try {
            return scan.nextDouble();
        } finally {
            scan.nextLine();
        }
    }

    @Override
    public String getString() {
        return scan.nextLine();
    }

    public void close() {
        scan.close();
    }

}

