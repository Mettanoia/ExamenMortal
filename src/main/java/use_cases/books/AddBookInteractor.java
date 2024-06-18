package use_cases.books;

import domain.Libro;
import domain.ResourcesCollection;
import use_cases.ResourcesCollectionGateway;

import java.io.IOException;

public final class AddBookInteractor {

    private final ResourcesCollectionGateway resourcesCollectionGateway;

    public AddBookInteractor(ResourcesCollectionGateway resourcesCollectionGateway) {
        this.resourcesCollectionGateway = resourcesCollectionGateway;
    }

    public void addBookToCollection(Libro libro, ResourcesCollection resourcesCollection) {

        resourcesCollection.addBook(libro);
        try {
            resourcesCollectionGateway.updateResourceCollection(resourcesCollection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
