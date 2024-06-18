package domain;

public final class DigitalResource extends LibraryResourceAbstract{

    private final String description;
    private final String name;
    private final Format format;

    public DigitalResource(int id, double prize, String description, String name, Format format) {
        super(id, prize);
        this.description = description;
        this.name = name;
        this.format = format;
    }

    @Override
    public String toString() {
        return "DigitalResource{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", format=" + format +
                ", prize=" + prize +
                '}';
    }

    public enum Format {
        MOVIE,
        MUSIC,
        PHOTOGRAPHIC_ALBUM
    }

}
