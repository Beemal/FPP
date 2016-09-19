package inheritance;

class Computer implements Cloneable{
	private String manufacturer;
	private String processor;
	private int ramSize;
	private int diskSize;
	private double processorSpeed;
	
	
	public Computer(String manufacturer, String processor, int ramSize,
			int diskSize, double processorSpeed) {
		this.manufacturer = manufacturer;
		this.processor = processor;
		this.ramSize = ramSize;
		this.diskSize = diskSize;
		this.processorSpeed = processorSpeed;
		}

	public int getRamSize() {
		return ramSize;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public double getProcessorSpeed() {
		return processorSpeed;
	}

	public double computePower() {
		return this.ramSize * this.processorSpeed;
	}

	@Override
	public String toString() {
		return "Driver [manufacturer=" + manufacturer + ", processor="
				+ processor + ", ramSize=" + ramSize + ", diskSize=" + diskSize
				+ ", processorSpeed=" + processorSpeed + "]";
	}
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Computer))
			return false;
		
		Computer c = (Computer)o;
		boolean equals = this.manufacturer.equals(c.manufacturer) && this.ramSize == c.ramSize && this.processor.equals(c.processor);
		
		return equals;
	}
	@Override
	public int hashCode(){
		int hash = 17; // user defined formula
		int h = hash*13 + this.manufacturer.hashCode()*this.processor.hashCode()*this.ramSize;
		return h;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		
		return super.clone();
		
	}
}

class NoteBook extends Computer {
	public NoteBook(String manufacturer, String processor, int ramSize,
			int diskSize, double processorSpeed, double height, double weight,
			double width) {
		super(manufacturer, processor, ramSize, diskSize, processorSpeed);
		// TODO Auto-generated constructor stub
		this.height = height;
		this.weight = weight;
		this.width = width;
	}

	private double height;
	private double width;
	private double weight;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double screenSize() {
		return height * width;
	}

	@Override
	public String toString() {
		return "NoteBook [height=" + height + ", width=" + width + ", weight="
				+ weight + ", screenSize =" + screenSize() + ", getRamSize ="
				+ getRamSize() + ", DiskSize = " + getDiskSize()
				+ " ProcessorSpeed =" + getProcessorSpeed()
				+ ", computePower = " + computePower() + "]";
	}
	
	
}

public class Driver5{
	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub

		Computer c1 = new Computer("DELL", "INTEL", 2, 500, 2.5);
		Computer c2 = new Computer("SAMSUNG", "INTEL", 4, 8, 2.8);
		Computer c3 = new Computer("DELL", "INTEL", 5, 500, 3.5);
		
		
	

		if (c1.equals(c2))
			System.out.println("C1 and C2 are equals");
		else
			System.out.println("C1 and C2 not equals");

		if (c1.equals(c3))
			System.out.println("C1 and C3 are equals");
		else
			System.out.println("C1 and C3 not equals");
		
		System.out.println("Hash Code of C1 = "+c1.hashCode());
		System.out.println("Hash Code of C2 = "+c2.hashCode());
		System.out.println("Hash Code of C3 = "+c3.hashCode());
		
		Computer c4 = (Computer) c1.clone();
		
		System.out.println(c4);
	}
}

/*OUTPUT
C1 and C2 not equals
C1 and C3 not equals
Hash Code of C1 = -459389111
Hash Code of C2 = 1180669133
Hash Code of C3 = -1148473109
Driver [manufacturer=DELL, processor=INTEL, ramSize=2, diskSize=500, processorSpeed=2.5]
*/
