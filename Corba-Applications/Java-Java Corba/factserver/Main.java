/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factserver;

import Fact.Factorial;
import Fact.FactorialHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Rupal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try{
        // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
      
      Factservant factserv = new Factservant();
        factserv.setORB(orb);
        
         org.omg.CORBA.Object ref = rootpoa.servant_to_reference(factserv);
         Factorial href = FactorialHelper.narrow(ref);
	  
      // get the root naming context
           org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
      
        NameComponent path[]=ncRef.to_name("ABC");
        ncRef.rebind(path, href);
        System.out.println("Hello server ready & waiting");
        
        orb.run();
        }
        
              catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Server Exiting ...");
    }
    
}
