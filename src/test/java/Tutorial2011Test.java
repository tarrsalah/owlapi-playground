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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tarrsalah
 */
public class Tutorial2011Test {

    private static final IRI documentIRI = IRI.create("http://127.0.0.1:3001/ontology/books.owl");
    private static final Logger logger = LoggerFactory.getLogger(Tutorial2011Test.class);
    private final OWLOntologyManager manager;
    private final OWLOntology booksOntology;

    public Tutorial2011Test() throws OWLOntologyCreationException {
        this.manager = OWLManager.createOWLOntologyManager();
        this.booksOntology = manager.loadOntologyFromOntologyDocument(Tutorial2011Test.documentIRI);

    }

    @Test
    public void shoudLoadOntology() throws OWLOntologyCreationException {
        assertNotNull(this.booksOntology);
        logger.info("shoudLoadOntology: {}",
                booksOntology.getOntologyID().toString());
    }
}
