import cli.CommandLineInterface;
import cli.MainMenuCLI;
import domain.DigitalResource;
import domain.LibraryResourceAbstract;
import domain.Libro;
import domain.ResourcesCollection;
import org.json.simple.JSONObject;
import use_cases.ResourcesCollectionGateway;
import use_cases.books.AddBookInteractor;
import use_cases.digital_resources.AddDigitalResourceInteractor;
import use_cases.library_resources.RemoveLibraryResourceInteractor;
import use_cases.resource_collections.CreateNewCollectionInteractor;

import java.io.*;
import java.util.List;
import java.util.Set;

final class App {
    static void run() {

        // ResourcesCollectionGateway mock implementation
        ResourcesCollectionGateway resourcesCollectionRepository = new ResourcesCollectionGateway() {

            // Mock database, JSON died
            Set<ResourcesCollection> database = Set.of(

                    new ResourcesCollection(1, "First", ResourcesCollection.AccessLevel.PUBLIC, 120.0, Set.of(
                                new Libro(1, 12.0, "Clean ARchitecture", 2.5, Libro.Category.CONSPIRACY_THEORIES),
                                new Libro(2, 22.0, "Picatrix", 2.5, Libro.Category.SELF_HELP),
                                new Libro(3, 56.0, "Muerte", 34.0, Libro.Category.HORROR),
                                new DigitalResource(4, 2.4, "Tons of Pugs", "Pugcast", DigitalResource.Format.PHOTOGRAPHIC_ALBUM))),

                    new ResourcesCollection(2, "SEcond", ResourcesCollection.AccessLevel.PRIVATE, 123.0, Set.of(
                                new Libro(1, 12.0, "Clean Code", 2.5, Libro.Category.CONSPIRACY_THEORIES),
                                new DigitalResource(4, 2.4, "Alien autopsy from 1947", "Roswell A2", DigitalResource.Format.MOVIE)))

            );

            @Override
            public void addResourceCollection(ResourcesCollection resourcesCollection) throws IOException {

                int lastId = database.stream().max(
                        (a, b) -> Math.max(a.getId(), b.getId())
                ).orElse(new ResourcesCollection(1, null, null, 0, null)).getId();

                resourcesCollection.setId(lastId + 1);

                database.add(resourcesCollection);

            }

            @Override
            public void updateResourceCollection(ResourcesCollection resourcesCollection) throws IOException {

                for (ResourcesCollection rc : database)
                    if (resourcesCollection.getId() == rc.getId()) {
                        database.remove(rc);
                        database.add(resourcesCollection);
                    }

            }

            @Override
            public void removeLibraryResource(int id, LibraryResourceAbstract.ResourceType resourceType) throws IOException {

                // TODO Add implementation here

            }

            // Mock method to be able to test the UI
            @Override
            public Set<ResourcesCollection> getAllResourceCollections() throws IOException {
                return database;
            }

        };

        // The different use cases we want to access from the menu
        CreateNewCollectionInteractor createNewCollectionInteractor = new CreateNewCollectionInteractor(resourcesCollectionRepository);
        AddBookInteractor addBookInteractor                         = new AddBookInteractor(resourcesCollectionRepository);
        AddDigitalResourceInteractor addDigitalResourceInteractor   = new AddDigitalResourceInteractor(resourcesCollectionRepository);
        RemoveLibraryResourceInteractor removeLibraryResourceInteractor = new RemoveLibraryResourceInteractor(resourcesCollectionRepository);

        // We inject only the methods so it lets the menu be completely decoupled
        // that way we can mock all these methods with just lambdas if we need an
        // instance of the menu o test new features.
        CommandLineInterface MainMenu =
                new MainMenuCLI(
                        createNewCollectionInteractor::addResourceCollection,
                        addBookInteractor::addBookToCollection,
                        addDigitalResourceInteractor::addDigitalResourceToCollection,
                        removeLibraryResourceInteractor::removeLibraryResource
                );

        MainMenu.scanInput();

    }
}
