package REST_TransmissionArticles;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Configuration du serveur TransmissionArticles
 */
@javax.ws.rs.ApplicationPath("webresources")
public class applicationConfig extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    /**
     * Do not modify addRestResourceClasses() method. It is automatically populated with all resources defined in the project. If required,
     * comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(REST_TransmissionArticles.articleRessource.class);
        resources.add(REST_TransmissionArticles.auteurRessource.class);
        resources.add(REST_TransmissionArticles.motsclesRessource.class);
    }
}
