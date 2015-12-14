/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

/**
 *
 * @author tarrsalah
 */
public class PlaygroundTest {

    private final IRI documentIRI;
    private final OWLOntologyManager manager;

    public PlaygroundTest() {
        this.documentIRI = IRI.create("http://127.0.0.1:3001/ontology/books.owl");
        this.manager = OWLManager.createOWLOntologyManager();
    }

    @Test
    public void shoudPrintSignature() throws OWLOntologyCreationException {
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(this.documentIRI);

        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        OWLReasonerConfiguration config = new SimpleConfiguration();
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
        System.out.println(reasoner.getRootOntology().getSignature());
    }
}
