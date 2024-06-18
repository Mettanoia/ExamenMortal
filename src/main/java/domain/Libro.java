package domain;

public final class Libro extends LibraryResourceAbstract {

    private final String title;
    private final double estimatedReadingTime;
    private final Category category;

    public Libro(int id, double prize, String title, double estimatedReadingTime, Category category) {
        super(id, prize);
        this.title = title;
        this.estimatedReadingTime = estimatedReadingTime;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", estimatedReadingTime=" + estimatedReadingTime +
                ", category=" + category +
                ", prize=" + prize +
                '}';
    }

    public enum Category {
        HORROR,
        CONSPIRACY_THEORIES,
        SCIENCE_FICTION,
        SELF_HELP
    }

}
