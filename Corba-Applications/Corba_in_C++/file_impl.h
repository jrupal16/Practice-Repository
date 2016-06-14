#ifndef __HELLO_IMPL_H__
#define __HELLO_IMPL_H__
 
#include "File_transfer.hh"
#include <string> 
class file_impl : public POA_Hello
{
    public:
        virtual char * get_file(const char * file_name);
};
 
#endif
