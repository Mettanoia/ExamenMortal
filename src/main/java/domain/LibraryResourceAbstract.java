package domain;


sealed public class LibraryResourceAbstract permits DigitalResource, Libro {

    protected final int id;
    protected final double prize;

    LibraryResourceAbstract(int id, double prize) {
        this.id = id;
        this.prize = prize;
    }

    public enum ResourceType {
        BOOK,
        DIGITAL_RESOURCE
    }

}

