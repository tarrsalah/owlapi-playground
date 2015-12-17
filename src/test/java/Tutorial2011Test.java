/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Set;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tarrsalah
 */
public class Tutorial2011Test {

    @Rule
    public TestName name = new TestName();

    private static final IRI documentIRI = IRI.create("http://127.0.0.1:3001/ontology/books.owl");
    private static final Logger logger = LoggerFactory.getLogger(Tutorial2011Test.class);
    private final OWLOntologyManager manager;
    private final OWLOntology booksOntology;

    @Before
    public void before() {
        logger.info(name.getMethodName());
    }

    public Tutorial2011Test() throws OWLOntologyCreationException {
        this.manager = OWLManager.createOWLOntologyManager();
        this.booksOntology = manager.loadOntologyFromOntologyDocument(Tutorial2011Test.documentIRI);

    }

    @Test
    public void shoudLoadOntology() throws OWLOntologyCreationException {
        assertNotNull(this.booksOntology);
        logger.info("Loading ontology from IRI: {}",
                booksOntology.getOntologyID().toString());
    }

    @Test
    public void shouldShowClasses() {
        final Set<OWLClass> clazzes = booksOntology.getClassesInSignature();
        logger.info("There is {} classes", clazzes.size());
        clazzes.stream().forEach((clazz) -> {
            assertNotNull(clazz);
        });

    }

    @Test
    public void shouldPrintOntology() throws IOException, OWLOntologyStorageException {
        final StringDocumentTarget target = new StringDocumentTarget();
        manager.saveOntology(booksOntology, new FunctionalSyntaxDocumentFormat(), target);
        logger.info(target.toString());
    }
}
