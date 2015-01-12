package Client;
import java.io.*;
import java.net.*;
public class client {
private ObjectOutputStream output;
private  ObjectInputStream input;
private String message="";
private String serverIP;
private Socket connection1;
public client() {
	// TODO Auto-generated constructor stub
}
//Method for connecttoServer
private void connecttoServer(){
	System.out.println("Attempting Connection.....\n");
	try {
		connection1=new Socket(InetAddress.getByName(serverIP),4444);
		System.out.println("Coneected to "+connection1.getInetAddress().getHostName());
		
		
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Couldn't be conected to Server");
		e.printStackTrace();
	}}
	//Setting up stream for Input and Output
	private void setupStreams(){
		try {
			output=new ObjectOutputStream(connection1.getOutputStream());
			output.flush();
			input=new ObjectInputStream(connection1.getInputStream());
			
			System.out.println("Your Connection is Now Established!!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Client Streams error!");
		}
		
		
	}
	//Establishing  whilechatting method//
	private void whileChatting(){
		do{
			try{
			try {
				message=(String) input.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n"+message);
			
			}catch(ClassNotFoundException e){
				System.out.println("CLASS NOT FOUND!!");
			}
		
		
	}while(!message.equals("Server--END"));
	
	}

//close the streams and Sockets
	private void closeCrap(){
		System.out.println("Closing The Program");
		try {
			output.close();
			input.close();
			connection1.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.println("Exception found in closing the sockets");
		}
		
	}
	//Send Messages to the sever
public void sendMessage(String message){
try {
	output.writeObject("CLIENT--"+message);
	output.flush();
System.out.println("\nCLient Message--"+message);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
	
}
	
	
	
	
//Connecting to Server!!
public void startrunning() throws EOFException{
	try{
		connecttoServer();
		setupStreams();
		whileChatting();
	}finally{
		closeCrap();
	}
}




}
