package Client;

import java.io.EOFException;

public class ClientTest {
public static void main(String[] args) {
	client c=new client();
try {
	c.startrunning();
} catch (EOFException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	

}
}
