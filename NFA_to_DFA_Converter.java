package net.pcleaks.parsAlg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
    static Queue<String> que = new LinkedList<String>();
    static String goal = getInput("gozareye hadaf");
    static String tmp = null;
    static String[][] nonTers = new String[5][11]; //5 ta nonterminal harkodom 10 ta ghaede -- darsorate taviz jahaye dg avaz she
//    static String result="que khali shodo peyda nashod! :(";
	public static void main(String[] args){
		System.out.println("hi   !! harja 0th mibinid 1th farz konid 1th ro 2th va betartib.. moshkel i+1");
		
//		String s = getInput("S vared konid");
		//farz mikonim s yek ghanon darad
	    int numNTer = getIntInput("chand non terminal darad ba ehtesabe S");
	    ArrayList<Integer> numNTerRules=new ArrayList<Integer>();
	
	    for (int i = 0; i < numNTer; i++) {
	    	numNTerRules.add(getIntInput("tedade ghavaed non terminal "+ (i+1) +"th"));
	    	nonTers[i][0] = getInput("esme non terminal "+ (i+1) +"th");
	    	for (int j = 1; j <= numNTerRules.get(i); j++) { // be tedade ghavaede nt e i om micharkhe
	    		nonTers[i][j] = getInput("enter ghaede " + j+"th non terminale "+ nonTers[i][0]) ;
			}
	    }//end of for gereftan ghavaed grammer
		  
	    //namayesh inayi ke gerefti
//	    System.out.println("S >> " + s);
	    for (int i = 0; i<5; i++){
	        for (int j = 0; j<11; j++){
	        	if (nonTers[i][j]!=null) {
	        		if (j==0) {
	        			System.out.print(nonTers[i][j] + " : ");
					}else {
						System.out.print(nonTers[i][j] + " | ");
					}
					
				}
	        	
	        	}
	        System.out.println();
	    	}

	    
	    
	        
		
	    //pardazesh asli	
	    que.add("S");
	    int counter =1;
	    while (!que.isEmpty()) { // ye sharte payan ine ke saf khali she 
	    	System.out.print("Step "+counter+" : ");
	    	if (Pishvand()) {
		System.out.println("pishvand okeye");
		tmp = que.element();
		que.remove();
		jagozari();
		
	    	}else {
		System.out.println("pishvand ok nis faghat hazf mikonim");
		que.remove();
	    	} 
	    counter++;
		}//end of while
	    
	    //System.out.println(result);
	    

	    


	    printQ();

	    	
		
	    
	    
	    }//end of main method
	    
	   
  
	public static void printQ(){
		for(String ss : que) { 
			  System.out.println(ss.toString()); 
			}
	}
	    
	public static void jagozari(){
	    char marja = 0; // nonterminai ke bayad moadelasho biari
	    int marjaI = 0;
		for (int i=tmp.length()-1; i>=0; i--) {//int i=tmp.length()-1; i>=0; i--     int i = 0; i < tmp.length(); i++
			 if(Character.isUpperCase(tmp.charAt(i))) {
				 marja = tmp.charAt(i);
				 marjaI=i;
			 }
		}
		if (marja==0) {//0 bashe yani hamash terminale tamome
			System.exit(0);
		}//end of peyda kardane avali harfe capital dar jomle sar saf
		
		
		
		//jagozarie marja ba moadelash
		
		for (int i = 0; i < 5; i++) { 
			if (nonTers[i][0]!=null) { //akhe chera bayad null bashe ??!!asd
				if (nonTers[i][0].charAt(0) == marja) {
				for (int j = 1; j < 11; j++) {
					if (nonTers[i][j]!=null){ 
						StringBuilder sb = new StringBuilder(tmp);
						sb.deleteCharAt(marjaI);
						sb.insert(marjaI, nonTers[i][j]);
						que.add(sb.toString());
						
						}
				}
				break;//peyda kard dg nagarde
				}
			}
			
		}//end of fore jagozari
		
	}//end of jagozari
	
	
	public static Boolean Pishvand(){
		 //calc  pishvand va print
	    String pishvand = "";
	    Boolean ok = true;
	    char[] charArray = que.element().toCharArray();
	    for (char c : charArray) {
	    	if (!Character.isLowerCase(c)) break; 
			pishvand = pishvand + c;
		}
	    if (pishvand.length()>goal.length()) {
			ok=false;
	    	return ok;
		}
	    if (pishvand.equals(goal)) {
	    	System.out.println("Hooray!! jomle jozve gramer hast  : "+pishvand); 
	    	return ok;
		}
	    char[] pishCharArray = pishvand.toCharArray();
	    char[] goalCharArray = goal.toCharArray();
	    for (int i = 0; i < pishCharArray.length; i++) {
			if (pishCharArray[i] != goalCharArray[i]) {
				ok = false;
			}
		}    
  	  System.out.println("pishvande feli : "+pishvand); 
	    return ok;
	}
	
	
//	public static ArrayList<String> strToArrL(String str){
//		ArrayList<String> arrayList = new ArrayList<String>();
//		for (int i = 0; i < str.length(); i++)
//		{
//		  char c = str.charAt(i);
//		  String answer = Character.toString(c);
//		  arrayList.add(answer);
//		}
//		return arrayList;	
//	}
	
	public static String getInput(String msg){
		Scanner scan = new Scanner( System.in );
		System.out.print( msg +" : " );
		return scan.nextLine();
	}
	public static Integer getIntInput(String msg){
		Scanner scan = new Scanner( System.in );
		System.out.print( msg +" : " );
		return Integer.parseInt(scan.nextLine());
	}
}
