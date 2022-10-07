import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Load_cash {
  
  
  public static void LoadingCash() throws IOException, ClassNotFoundException
  {
         Scanner sc=new Scanner(System.in);
         
        LinkedHashMap<Integer,Integer> tm=new  LinkedHashMap<Integer,Integer>();
	    FileOutputStream fo=new FileOutputStream("CashDetails.txt");
		ObjectOutputStream os=new ObjectOutputStream(fo);
	
	    int i1=0,i2=0,i3=0;
		
		System.out.print("2000 :");
		int val1=sc.nextInt();
		System.out.print("500 :");
		int val2=sc.nextInt();
		System.out.print("100 :");
		int val3=sc.nextInt();
        
	
		i1=tm.get(2000);
		i2=tm.get(500);
		i3=tm.get(100);
		
	   tm.put(2000,i1+val1);
       tm.put(500,i2+val2);
       tm.put(100,i3+val3);
       
       os.writeObject(tm);
       os.flush();
       
       LinkedHashMap<Integer,Integer> ttm=new LinkedHashMap<Integer,Integer>();
       ObjectInputStream is=new ObjectInputStream(new FileInputStream("CashDetails.txt"));
       
	   
		ttm=( LinkedHashMap)is.readObject();
		
	//	System.out.println(ttm);
	   
		for(Map.Entry m:ttm.entrySet()){ 
			int b=(int) m.getKey();
			int a=(int) m.getValue();
	        System.out.println(m.getKey()+" - "+m.getValue()+"=>"+a*b);    
	       } 

	  
  }	
  public static void ATMBalance() throws FileNotFoundException, IOException, ClassNotFoundException
  {
	  LinkedHashMap<Integer,Integer> tm=new LinkedHashMap<Integer,Integer>();
      ObjectInputStream iis=new ObjectInputStream(new FileInputStream("CashDetails.txt"));
      tm=( LinkedHashMap)iis.readObject();
      for(Map.Entry m:tm.entrySet()){ 
	        System.out.println(m.getKey()+" - "+m.getValue());    
	       }  
	  
  }
  
  
  public static void withdrawAmount(int Acno,ArrayList<Customer_Details> ll) throws ClassNotFoundException, IOException
  {
	  System.out.println("Max withdrawal limit for a single transaction is10,000 and minimum is100.");
		Scanner sc=new Scanner(System.in);
	  LinkedHashMap<Integer,Integer> tm=new LinkedHashMap<Integer,Integer>();
      ObjectInputStream iis=new ObjectInputStream(new FileInputStream("CashDetails.txt"));
	
      tm=(LinkedHashMap)iis.readObject();
    
	
	System.out.print("Enter the Amount :");
	int Amount=sc.nextInt();

	for (Customer_Details details : ll) {
		int $2k = 0,$500=0,$100=0;
		if(Acno==details.getId())
		{
        if(Amount<=details.getAccBal())
	    {
        	 for(int i=0;i<ll.size();i++)
        	 {
        		 if(ll.get(i).getId()==Acno)
        		 {			
        			 int minus=ll.get(i).getAccBal()-Amount;
        			ll.get(i).setAccBal(minus);
        		 }
        		 
        	 }
        	   FileOutputStream fo=new FileOutputStream("Details.txt");
        	   ObjectOutputStream os=new ObjectOutputStream(fo);
        		os.writeObject(ll);
        		//System.out.println("Successfully Transfered");
        	
        	
        	
          int $2000c= tm.get(2000);
          int $500c= tm.get(500);
          int $100c= tm.get(100);
	
        
          if(Amount>5000)
          {
        	  int amt=Amount;
        	$2k=amt/2000;
        	amt%=2000;
        	$500=amt/500;
        	amt%=500;
        	$100=amt/100;
          }
          else if(Amount<=5000){
        	  int amt=Amount;
            $2k=amt/2000;
          	amt%=2000;
          	$500=amt/500;
          	amt%=500;
          	$100=amt/100; 
          }
          
          int val2k=tm.get(2000);
          int val500=tm.get(500);
          int val100=tm.get(100);          
           
         tm.remove(2);
         tm.remove(1);
         tm.remove(0);
         
          
		tm.put(2000,val2k-$2k);
		tm.put(500,val500-$500); 
		tm.put(100,val100-$100);   
          
		FileOutputStream ff=new FileOutputStream("CashDetails.txt");
		ObjectOutputStream s=new ObjectOutputStream(ff);		
		 s.writeObject(tm);
		 s.close();
//		 LinkedHashMap<Integer,Integer> tmm=new LinkedHashMap<Integer,Integer>();
//	      ObjectInputStream iims=new ObjectInputStream(new FileInputStream("CashDetails.txt"));
//		
//	      tmm=(LinkedHashMap)iims.readObject();
//		 
//		 for(Map.Entry m:tmm.entrySet())
//		 {
//			 System.out.println(m);
//		 }
		 
		 
		 }
        else {
        	System.out.println("Insufficient Amount !!");
        }
		}
	 
	}			
  }

}
