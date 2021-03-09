package pack2;

import java.awt.image.BufferedImage;

public class Buffer {
	private BufferedImage picture = null;
	private boolean available = false ;
	
	public synchronized BufferedImage get () {
		while (!available ) {
			try {
				wait();
				// Asteapta producatorul sa puna o imagine
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false ;
		notifyAll ();
		return picture;
	}
	
	public synchronized void put (BufferedImage picture ) {
		while ( available ) {
			try {
				wait();
			// Asteapta consumatorul sa preia imaginea
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.picture = picture ;
		available = true;
		notifyAll ();
	}


}
