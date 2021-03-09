package pack1;

import pack2.Consumer;
import pack2.Producer;
import pack2.Buffer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestGrayScale {

	public static void main(String[] args) throws IOException {
		Buffer b = new Buffer();
		File src = null;
		File dest = null;
		if (args.length==0) {
			Scanner myScanner = new Scanner(System.in);
			
			System.out.println("Introduceti sursa:");
		    String srcPath = myScanner.nextLine();  // Citeste sursa imagine
		    src = new File(srcPath);
		    
		    System.out.println("Introduceti destinatie:");
		    String destPath = myScanner.nextLine(); // Citeste destinatie
		    dest = new File(destPath);
		    
		    myScanner.close();
		}
		else {
			//Citire sursa si destinatie din linia de comanda
			src = new File(args[0]);
			dest = new File(args[1]);
		}
		dest.createNewFile();
		Producer p1 = new Producer(src, b);
		Consumer c1 = new Consumer(dest, b);
		p1.start();
		c1.start();
	}

}
