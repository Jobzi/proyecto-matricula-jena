/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Iterator;
import static org.apache.jena.enhanced.BuiltinPersonalities.model;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

/**
 *
 * @author Jipso
 */
public class Ontology {
    OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        

    public Ontology() {
        model.read("file:///Users/matricula.owl","RDF/XML");
    }
    
    void Read(){
        for (Iterator<OntClass> i = model.listClasses();i.hasNext();){
            OntClass cls = i.next();
            System.out.print(cls.getLocalName()+": ");
                for(Iterator it = cls.listInstances(true);it.hasNext();){
                Individual ind = (Individual)it.next();
                    if(ind.isIndividual()){
                        System.out.print(ind.getLocalName()+" ");
                    }
                }
            System.out.println();
        }
    }

    public OntModel getModel() {
        return model;
    }
    
}
