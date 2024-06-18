package use_cases.library_resources;

import domain.LibraryResourceAbstract;
import use_cases.ResourcesCollectionGateway;

import java.io.IOException;

public final class RemoveLibraryResourceInteractor {

    private final ResourcesCollectionGateway resourcesCollectionGateway;


    public RemoveLibraryResourceInteractor(ResourcesCollectionGateway resourcesCollectionGateway) {
        this.resourcesCollectionGateway = resourcesCollectionGateway;
    }

    public void removeLibraryResource(int id, LibraryResourceAbstract.ResourceType resourceType) {

        try {
            resourcesCollectionGateway.removeLibraryResource(id, resourceType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
