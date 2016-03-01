
//import gsoc.DateDemo;
import java.io.*;
import java.net.*;
public class Gsoc 
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server  ready for chatting");
      Socket sock = sersock.accept( );                          
                              // reading from keyboard (keyRead object)
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                      // sending to client (pwrite object)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
                              // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage = "";               
      while(!sendMessage.equals("stop"))
      {
          int flag=0;
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
            if(receiveMessage.equals("hey")||receiveMessage.equals("hi")){
                          sendMessage="Good Morning sir";
                          pwrite.println(sendMessage);
                          flag=1;
                    }
           else if(receiveMessage.equals("date")||receiveMessage.equals("Date"))
                {
   
                       try{
       // Process p = Runtime.getRuntime().exec("javac -classpath C:\\Users\\KARTIK PC\\Documents NetBeansProjects\\gsoc.build.classes.DateDemo.java");
       // p.waitFor();
                                Process p1 = Runtime.getRuntime().exec("java -cp C:/phone DateDemo");
                                InputStream is = p1.getInputStream();
        
        
                                InputStreamReader isr =  new InputStreamReader(is);
                                BufferedReader br1 = new BufferedReader(isr);
        
                                      
                                if((sendMessage = br1.readLine())!= null)
                                {
                                    pwrite.println(sendMessage);
                                flag=1;
                                }
                                 else
                                        {
                                                 pwrite.println("no output");
                                                 break;
                                                    }
                       }
                            catch(Exception e){
                                                    e.printStackTrace();
                                                }
                }
       else if(receiveMessage.equals("Calender")||receiveMessage.equals("calender"))
                {
   
                       try{
       // Process p = Runtime.getRuntime().exec("javac -classpath C:\\Users\\KARTIK PC\\Documents NetBeansProjects\\gsoc.build.classes.DateDemo.java");
       // p.waitFor();
                                Process p2 = Runtime.getRuntime().exec("java -cp C:/phone CalenderDemo");
                                InputStream is1 = p2.getInputStream();
        
        
                                InputStreamReader isr1 =  new InputStreamReader(is1);
                                BufferedReader br11 = new BufferedReader(isr1);
        
                                      
                                if((sendMessage = br11.readLine())!= null){
                                pwrite.println(sendMessage);
                                flag=1;
                                }
                                 else
                                        {
                                                 pwrite.println("no output");
                                                // break;
                                                    }
                       }
                            catch(Exception e){
                                                    e.printStackTrace();
                                                }
                }
       
        //String line;
        //while ((line = br1.readLine()) != null) {
        //System.out.println(line);
     
            else
           System.out.println(receiveMessage);
           
        }         
        if(flag==0){
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
        }
        
        
        
      }
      pwrite.close();
    } 
}
                        