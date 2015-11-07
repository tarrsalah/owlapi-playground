/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tarrsalah.owlapi.playground;

import java.io.File;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * @author tarrsalah
 */
public class Main {
    public static void main(String[] args) throws OWLOntologyCreationException {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        IRI documentIRI = IRI.create("http://127.0.0.1:3001/static/ontology/portal.owl");
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(documentIRI);
        System.out.println(ontology.toString());
    }
}
