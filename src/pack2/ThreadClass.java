package pack2;

public abstract class ThreadClass extends Thread{
	private boolean flag;
	
	public ThreadClass(boolean flag) {
		this.setFlag(flag);
		if (flag) setName("Consumator");
		else setName("Producator");
		System.out.println("Constructor " + getName());
	}
	
	@Override
	public void start() {
		System.out.println("Starting " + getName());
		super.start();
	}
	
	public void run() {
		System.out.println("Running " + getName());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
