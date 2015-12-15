/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * @author tarrsalah
 */
public class Tutorial2011Test {

    private static final IRI documentIRI = IRI.create("http://127.0.0.1:3001/ontology/books.owl");
    private final OWLOntologyManager manager;

    public Tutorial2011Test() {
        this.manager = OWLManager.createOWLOntologyManager();
    }

    @Test
    public void shoudLoadOntology() throws OWLOntologyCreationException {
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(Tutorial2011Test.documentIRI);
        assertNotNull(ontology);
    }
}
