package pack2;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class GrayImage implements ConvertToGray{
	BufferedImage origPicture;
	BufferedImage greyPicture;
	
	public GrayImage(BufferedImage origPicture) {
		super();
		this.origPicture = origPicture;
		int h = getHeight();
		int w = getWidth();
		greyPicture = new BufferedImage (w, h, BufferedImage.TYPE_3BYTE_BGR); //initializare imagine pentru scriere
	}

	public BufferedImage getOrigPicture() {
		return origPicture;
	}

	public void setOrigPicture(BufferedImage origPicture) {
		this.origPicture = origPicture;
	}
	
	public void writeGrayImage(File out) throws IOException{
		ImageIO.write(greyPicture, "bmp", out);
	}
	
	public int getHeight() {
		return origPicture.getHeight();
	}
	
	public int getWidth() {
		return origPicture.getWidth();
	}

	@Override
	public void toGrayScale(double ...arr) {
		//Ponderi culori
		double cr = 0, cg = 0, cb = 0;
		switch(arr.length) {
		case 0:
			cr = 0.2126;
			cg = 0.7152;
			cb = 0.0722;
			break;
		case 1:
			cr = arr[0];
			cg = (1-arr[0])/2;
			cb = (1-arr[0])/2;
			break;
		case 2:
			cr = arr[0];
			cg = arr[1];
			cb = 1-arr[0]-arr[1];
			break;
		default:
			cr = arr[0];
			cg = arr[1];
			cb = arr[2];
		}
		int w = origPicture.getWidth();
		int h = origPicture.getHeight();
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				Color c = new Color(origPicture.getRGB(j, i)); //se parcurge fiecare pixel al imaginii
				int redColor = (int) (c.getRed() * cr);
				int greenColor = (int) (c.getGreen() * cg);
				int blueColor = (int) (c.getBlue() * cb);
				Color newC = new Color(redColor + greenColor + blueColor, redColor + greenColor + blueColor, redColor + greenColor + blueColor);
				greyPicture.setRGB(j, i, newC.getRGB()); //se inlocuieste culoarea pixelului cu griul obtinut
			}
		}
	}
	
	
}
