package org.lessons.java.books;

public class Book {
    private String title;
    private int pages;
    private String author;
    private String editor;

    public Book(String title, int pages, String author, String editor) throws IllegalArgumentException {
        validateTitle(title);
        validatePages(pages);
        validateAuthor(author);
        validateEditor(editor);
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

    public void setTitle(String title) {
        validateTitle(title);
    }
    public void setPages(int pages) {
        validatePages(pages);
    }
    public void setAuthor(String author) {
        validateAuthor(author);
    }
    public void setEditor(String editor) {
        validateEditor(editor);
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Titolo non valido");
        }
        this.title = title;
    }
    private void validatePages(int pages) {
        if (pages < 1) {
            throw new IllegalArgumentException("Numero pagine maggiore di 0");
        }
        this.pages = pages;
    }
    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Autore non valido");
        }
        this.author = author;
    }
    private void validateEditor(String editor) {
        if (editor == null || editor.trim().isEmpty()) {
            throw new IllegalArgumentException("Editore non valido");
        }
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "title: " + title + ", " +
                "pages: " + pages + ", " +
                "author: " + author + ", " +
                "editor: " + editor + ", ";
    }
}
