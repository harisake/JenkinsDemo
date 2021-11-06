package com.test.auto.framework.customException;

@SuppressWarnings("serial")
public class ExecutionTimeException  extends RuntimeException{
	
/**
* Execution time exception
* @param s
*/
public ExecutionTimeException(String s)
{
    super(s);
}
}
