package org.lessons.java.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfBooks = 0;
        boolean isValid = false;

        do {
            try {
                System.out.println("Inserire il numero di libri: ");
                numberOfBooks = Integer.parseInt(scan.nextLine());

                if (numberOfBooks > 0) {
                    isValid = true;
                } else {
                    System.out.println("- Il numero deve essere maggiore di 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("- Numero non valido!");
            }
        } while (!isValid);

        Book[] books = new Book[numberOfBooks];

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("\n- Libro N." + (i + 1));

            boolean areValid = false;

            do {
                try {
                    System.out.println("Inserire il titolo: ");
                    String title = scan.nextLine();

                    System.out.println("Inserire il numero di pagine: ");
                    int pages = Integer.parseInt(scan.nextLine());

                    System.out.println("Inserire l'autore: ");
                    String author = scan.nextLine();

                    System.out.println("Inserire l'editore: ");
                    String editor = scan.nextLine();

                    books[i] = new Book(title, pages, author, editor);
                    areValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Numero non valido");
                } catch (IllegalArgumentException e) {
                    System.out.println("- Errore: " + e.getMessage());
                }
            } while (!areValid);

            System.out.println("- Libro creato con successo!");
        }

        scan.close();

        try (FileWriter fileWriter = new FileWriter("./resources/books.txt")){
            for (Book book : books) {
                fileWriter.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("\n- Impossibile scrivere nel file");
        }

        try (Scanner fileReader = new Scanner(new File("./resources/books.txt"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n- File non trovato");
        }
    }
}
