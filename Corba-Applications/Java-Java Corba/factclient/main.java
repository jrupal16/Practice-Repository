/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factclient;

import Fact.Factorial;
import Fact.FactorialHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Rupal
 */
public class main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ORB orb = ORB.init(args,null);
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
         Factorial fact=(Factorial) FactorialHelper.narrow(ncRef.resolve_str("ABC"));
	System.out.println("FACTORIAL OF RECEIVED NUMBER IS : ");       
	
        int a =fact.fact((int) 6);
        System.out.println(a);
       
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) 
        
        {
             System.out.println("Exception" +e);
        }
        
        
    }

   
    
    
}
