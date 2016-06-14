#include "file_impl.h"
#include <iostream>
#include <CORBA.h>
#include <coss/CosNaming.h>
 
using namespace std;
 
int main(int argc, char ** argv)
{
    try {
        // init ORB
        CORBA::ORB_ptr orb = CORBA::ORB_init(argc, argv);
 
        // init POA
        CORBA::Object_var poa_obj = orb->resolve_initial_references("RootPOA");
        PortableServer::POA_var poa = PortableServer::POA::_narrow(poa_obj);
        PortableServer::POAManager_var manager = poa->the_POAManager();
 
        // create service
        file_impl * service = new file_impl;
 
        // register within the naming service
        try {
            CORBA::Object_var ns_obj = orb->resolve_initial_references("NameService");
            if (!CORBA::is_nil(ns_obj)) {
                CosNaming::NamingContext_ptr nc = CosNaming::NamingContext::_narrow(ns_obj);
                CosNaming::Name name;
                name.length(1);
                name[0].id = CORBA::string_dup("TestServer");
                name[0].kind = CORBA::string_dup("");
                nc->rebind(name, service->_this());
                cout << argv[0] << ": server 'TestServer' bound" << endl;
            }
        } catch (CosNaming::NamingContext::NotFound &) {
            cerr << "not found" << endl;
        } catch (CosNaming::NamingContext::InvalidName &) {
            cerr << "invalid name" << endl;
        } catch (CosNaming::NamingContext::CannotProceed &) {
            cerr << "cannot proceed" << endl;
        }
 
        // run
        manager->activate();
        orb->run();
 
        // clean up
        delete service;
 
        // quit
        orb->destroy();
    } catch (CORBA::UNKNOWN) {
        cerr << "unknown exception" << endl;
    } catch (CORBA::SystemException &) {
        cerr << "system exception" << endl;
    }
}
