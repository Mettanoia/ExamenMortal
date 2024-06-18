package use_cases.digital_resources;

import domain.DigitalResource;
import domain.ResourcesCollection;
import use_cases.ResourcesCollectionGateway;

import java.io.IOException;

public class AddDigitalResourceInteractor {

    private final ResourcesCollectionGateway resourcesCollectionGateway;

    public AddDigitalResourceInteractor(ResourcesCollectionGateway resourcesCollectionGateway) {
        this.resourcesCollectionGateway = resourcesCollectionGateway;
    }

    public void addDigitalResourceToCollection(DigitalResource digitalResource, ResourcesCollection resourcesCollection) {

        resourcesCollection.addDigitalResource(digitalResource);
        try {
            resourcesCollectionGateway.updateResourceCollection(resourcesCollection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
