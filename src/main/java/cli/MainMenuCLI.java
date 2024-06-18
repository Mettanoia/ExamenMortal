package cli;

import domain.DigitalResource;
import domain.LibraryResourceAbstract;
import domain.Libro;
import domain.ResourcesCollection;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class MainMenuCLI implements CommandLineInterface {

    private final Scanner sc;
    private final Consumer<ResourcesCollection> addResourceCollectionMixin;
    private final BiConsumer<Libro, ResourcesCollection> addBookToCollectionMixin;
    private final BiConsumer<DigitalResource, ResourcesCollection> addDigitalResourceToMixin;
    private final BiConsumer<Integer, LibraryResourceAbstract.ResourceType> removeLibraryResourceMixin;

    public MainMenuCLI(Consumer<ResourcesCollection> addResourceCollectionMixin, BiConsumer<Libro, ResourcesCollection> addBookToCollectionMixin, BiConsumer<DigitalResource, ResourcesCollection> addDigitalResourceToMixin, BiConsumer<Integer, LibraryResourceAbstract.ResourceType> removeLibraryResourceMixin) {
        this.removeLibraryResourceMixin = removeLibraryResourceMixin;
        this.sc = new Scanner(System.in);
        this.addResourceCollectionMixin = addResourceCollectionMixin;
        this.addBookToCollectionMixin = addBookToCollectionMixin;
        this.addDigitalResourceToMixin = addDigitalResourceToMixin;
    }


    @Override
    public void scanInput() {

        do {

            System.out.println("What are you here for?\n1 - Create a new collection");

            switch (sc.nextInt()) {
                case 1:
                    new AddResourceCollectionMenuCLI(addResourceCollectionMixin).scanInput();
                    break;
                    // TODO Add the rest of menus and use cases
            }
        } while (false);

    }

}

