package java_Core4.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StreamDemo3 {

	public static void main(String[] args) {
		
		try {
			//¹ÜµÀÁ÷
			PipedInputStream in = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream(in);
			
			Send send = new Send(out);
			Receiver rec = new Receiver(in);
			
			send.send();
			rec.receive();
			
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

class Send{
	OutputStream out;

	public Send(OutputStream out) {
		super();
		this.out = out;
	}
	public void send(){
		byte value = (byte) (Math.random()*100);
		System.out.println("send " + value);
		try {
			out.write(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}



class Receiver{
	InputStream in;
	public Receiver(InputStream in) {
		super();
		this.in = in;
	}
	public void receive(){
		try {
			byte value = (byte) in.read();
			System.out.println("receive " + value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




