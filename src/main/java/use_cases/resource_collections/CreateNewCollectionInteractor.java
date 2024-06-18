package use_cases.resource_collections;

import domain.ResourcesCollection;
import use_cases.ResourcesCollectionGateway;

import java.io.IOException;

public final class CreateNewCollectionInteractor {

    private final ResourcesCollectionGateway resourcesCollectionGateway;

    public CreateNewCollectionInteractor(ResourcesCollectionGateway resourcesCollectionGateway) {
        this.resourcesCollectionGateway = resourcesCollectionGateway;
    }

    public void addResourceCollection(ResourcesCollection resourcesCollection){
        try {
            resourcesCollectionGateway.addResourceCollection(resourcesCollection);
        } catch (IOException e) {
            // Nothing special todo rn so we just rethrow it
            throw new RuntimeException(e);
        }
    }

}
