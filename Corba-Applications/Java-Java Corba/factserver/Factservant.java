/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factserver;

import Fact.FactorialPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Rupal
 */
public class Factservant extends FactorialPOA {

    private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
  
  // implement fact(long num1) method
    public int fact(int number1)
  {
	System.out.println("Parameters received on server are, "+number1);
        if (number1==0||number1==1)
        return 1;
        
        else {
            return number1*fact(number1-1);	
        }
  }
   // implement shutdown() method
    public void shutdown() {
    orb.shutdown(false);
  }   
}

