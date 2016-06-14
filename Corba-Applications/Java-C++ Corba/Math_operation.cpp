#include "Math_operation.h"
#include <iostream>
#include <fstream>
#include <string>
 
using namespace std;
 
long Math_operation::math_op(long op1, long op2, long op3)
{

	long ret;

	switch(op3) {
		case 0:
			ret = op1 + op2;
			break;
		case 1:
			ret = op1 - op2;
			break;
		case 2:
			ret = op1/op2;
			break;
		case 3:
			ret = op1 * op2;
			break;
		default:
			ret = -1;
	}

	return(ret);
}
