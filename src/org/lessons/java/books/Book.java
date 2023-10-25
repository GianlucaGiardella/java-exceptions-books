package org.lessons.java.books;

public class Book {
    private String title;
    private int pages;
    private String author;
    private String editor;

    public Book(String title, int pages, String author, String editor) throws IllegalArgumentException {
        validateString(title, "Titolo");
        validatePositiveNumber(pages, "Il numero di pagine");
        validateString(author, "Autore");
        validateString(editor, "Editore");

        this.title = title;
        this.pages = pages;
        this.author = author;
        this.editor = editor;
    }

    public String getTitle() {
        return title;
    }
    public int getPages() {
        return pages;
    }
    public String getAuthor() {
        return author;
    }
    public String getEditor() {
        return editor;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        validateString(title, "Titolo");
        this.title = title;
    }
    public void setPages(int pages) throws IllegalArgumentException {
        validatePositiveNumber(pages, "Numero");
        this.pages = pages;
    }
    public void setAuthor(String author) throws IllegalArgumentException {
        validateString(author, "Autore");
        this.author = author;
    }
    public void setEditor(String editor) throws IllegalArgumentException {
        validateString(editor, "Editore");
        this.editor = editor;
    }

    private void validateString(String inputString, String stringName) throws IllegalArgumentException {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(stringName + " è null o vuoto");
        }
    }

    private void validatePositiveNumber(int number, String stringName) throws IllegalArgumentException {
        if (number < 1) {
            throw new IllegalArgumentException(stringName + " è minore di 1");
        }
    }

    @Override
    public String toString() {
        return "title: " + title + ", " +
                "pages: " + pages + ", " +
                "author: " + author + ", " +
                "editor: " + editor + ", ";
    }
}
