#include "file_impl.h"
#include <iostream>
#include <fstream>
#include <string>
 
using namespace std;
 
char *file_impl::get_file(const char * file_name)
{

	cout << "MICO C++ server: " << file_name << endl;

	std::ifstream ifs(file_name);
	std::string content( (std::istreambuf_iterator<char>(ifs) ),
                       (std::istreambuf_iterator<char>()    ) );
	char *file_content = new char [content.length() + 1];
	strcpy(file_content, content.c_str());
	return (file_content);
/*
    char * server = CORBA::string_alloc(32);
    strncpy(server, "MICO C++ server", 32);
    return server;
*/
}
