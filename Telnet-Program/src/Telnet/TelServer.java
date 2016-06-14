package Telnet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class TelServer {   
	  public static void main (String[] args) throws IOException {
		  
		  
	    ServerSocket socketserv = new ServerSocket(8800);
 	    System.out.println("Server is start");
	    
	    try {  
	    	
	      Socket socket = socketserv.accept();
	      System.out.println("Request Accepted");
	      try {
	    	 
	       BufferedReader in =  new BufferedReader(
	         new InputStreamReader(socket.getInputStream())); 
	       PrintWriter out =  new PrintWriter(new BufferedWriter (
	         new OutputStreamWriter(socket.getOutputStream())),true);
	       
	       while (true) { 
	          String string = in.readLine();
	        System.out.println(string);
	          
	        if (string.toLowerCase().equals("pwd"))
	          
	            {
	        	 out.println(System.getProperty("user.dir")); 
	        	 }
	        
	          else if(string.toLowerCase().equals("ls"))
	            
	             {
	        	  File ls = new File(".");
	        	  File[] filelist = ls.listFiles();
	    		  StringBuilder lists=new StringBuilder();
	          for (int i = 0; i < filelist.length; i++){
	            	  lists.append( filelist[i].getName()+" ");
	            }
	          out.println("Files in the Directory are:"+ lists);
	          }
	        
	          else 
	        	  out.println("please enter correct command");
	           }
	       
	      } finally {
	        socket.close();
	      }} finally {
	      socketserv.close();   
	}  } } 