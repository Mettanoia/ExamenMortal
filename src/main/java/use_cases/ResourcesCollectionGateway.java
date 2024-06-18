package use_cases;

import domain.LibraryResourceAbstract;
import domain.ResourcesCollection;

import java.io.IOException;
import java.util.Set;

public interface ResourcesCollectionGateway {
    void addResourceCollection(ResourcesCollection resourcesCollection) throws IOException;
    void updateResourceCollection(ResourcesCollection resourcesCollection) throws IOException;
    void removeLibraryResource(int id, LibraryResourceAbstract.ResourceType resourceType) throws IOException;
    Set<ResourcesCollection> getAllResourceCollections() throws IOException;
}
