#ifndef __MATH_OPERATION_H__
#define __MATH_OPERATION_H__
 
#include "Add.hh"
#include <string>

class Math_operation : public POA_Add
{
    public:
        virtual long math_op(long op1, long op2, long op );
};
 
#endif

