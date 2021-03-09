package pack2;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class Producer extends ThreadClass {
	private File file;
	private Buffer myBuffer;
	
	public Producer (File f, Buffer b) {
		super(false);
		myBuffer = b;
		file = f;
		}
	
	@Override
	public void run () {
		super.run();
		long startTime = System.currentTimeMillis();
		try {
			BufferedImage picture = ImageIO.read(file);
			myBuffer.put(picture); //se pune informatia in buffer
		} catch (IOException e1) {
			System.out.println("Nu exista fisierul");
			e1.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Citirea a durat:" + (endTime-startTime) + "milisecunde");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Going dead " + getName());
	}

}
