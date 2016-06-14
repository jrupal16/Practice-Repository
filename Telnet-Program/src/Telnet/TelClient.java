package Telnet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TelClient {
	  @SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		  
	   Socket socketserv =  new Socket("localhost", 8800);  
	    
	    try {
	    	
	      BufferedReader in = new BufferedReader (
	        new InputStreamReader (socketserv.getInputStream()));  
	      PrintWriter out = new PrintWriter(new BufferedWriter (
	        new OutputStreamWriter(socketserv.getOutputStream())),true);   
	      
	      
	      while(true) {
	      Scanner i = new Scanner(System.in); 
	    	 String message = i.nextLine();
	    	out.println(message);
	    	System.out.println(in.readLine());
	    	 
	      }
	      
	        
	     }
	    
	    
	    finally {
	      socketserv.close();   
	}  }}  

//cs540s7	dXUvs#6a
