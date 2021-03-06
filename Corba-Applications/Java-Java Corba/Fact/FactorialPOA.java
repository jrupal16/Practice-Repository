package Fact;


/**
* Fact/FactorialPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Fact.idl
* Monday, April 27, 2015 2:24:56 PM PDT
*/

public abstract class FactorialPOA extends org.omg.PortableServer.Servant
 implements Fact.FactorialOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("fact", new java.lang.Integer (0));
    _methods.put ("shutdown", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Fact/Factorial/fact
       {
         int number1 = in.read_long ();
         int $result = (int)0;
         $result = this.fact (number1);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // Fact/Factorial/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Fact/Factorial:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Factorial _this() 
  {
    return FactorialHelper.narrow(
    super._this_object());
  }

  public Factorial _this(org.omg.CORBA.ORB orb) 
  {
    return FactorialHelper.narrow(
    super._this_object(orb));
  }


} // class FactorialPOA
