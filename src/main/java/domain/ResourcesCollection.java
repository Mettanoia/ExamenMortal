package domain;

import java.util.List;
import java.util.Set;

public final class ResourcesCollection {

    private int id;
    private final String name;
    private final AccessLevel accessLevel;
    private final Set<LibraryResourceAbstract> libraryResources;

    public ResourcesCollection(int id, String name, AccessLevel accessLevel, double totalPrize, Set<LibraryResourceAbstract> libraryResources) {
        this.id = id;
        this.name = name;
        this.accessLevel = accessLevel;
        this.libraryResources = libraryResources;
    }

    public void addBook(Libro libro) {
        libraryResources.add(libro);
    }

    public void addDigitalResource(DigitalResource digitalResource) {
        libraryResources.add(digitalResource);
    }

    public enum AccessLevel {
        PUBLIC,
        PRIVATE,
        RESTRICTED
    }

    @Override
    public String toString() {
        return "ResourcesCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessLevel=" + accessLevel +
                ", libraryResources=" + libraryResources +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
