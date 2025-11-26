public class Book {
    private String id;
    private String title;
    private String author;
    private boolean issued;

    public Book(String id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issue() {
        this.issued = true;
    }

    public void returnBook() {
        this.issued = false;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (issued ? "Issued" : "Available");
    }

    public String toFileString() {
        return id + ";" + title + ";" + author + ";" + issued;
    }

    public static Book fromFileString(String line) {
        String[] p = line.split(";");
        return new Book(p[0], p[1], p[2], Boolean.parseBoolean(p[3]));
    }
}
