package pack2;

import java.awt.image.BufferedImage;
import java.io.*;


public class Consumer extends ThreadClass{
	private Buffer myBuffer;
	private File file;
	
	public Consumer ( File f, Buffer b) {
		super(true);
		myBuffer = b;
		file = f;
	}
	
	@Override
	public void run () {
		super.run();
		BufferedImage picture = myBuffer.get(); //ia imaginea din buffer
		long startTime = System.currentTimeMillis();
		System.out.println("Se proceseaza imaginea");
		GrayImage newPicture = new GrayImage(picture); //se creaza un obiect de tip GrayImage din imaginea primita
		newPicture.toGrayScale(0.2126, 0.7152, 0.0722); //conversie imagine folosind weighted method
		long endTime = System.currentTimeMillis();
		System.out.println("Conversia a durat:" + (endTime-startTime) + "milisecunde");
		try {
			newPicture.writeGrayImage(file); //afisare imagine
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Going dead " + getName());
	}
}
