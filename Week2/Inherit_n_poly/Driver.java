package inheritance;

class Computer {
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
	
	public double computePower(){
		return this.ramSize * this.processorSpeed; 
	}
	
	@Override
	public String toString() {
		return "Driver [manufacturer=" + manufacturer + ", processor="
				+ processor + ", ramSize=" + ramSize + ", diskSize=" + diskSize
				+ ", processorSpeed=" + processorSpeed + "]";
	}

}
class NoteBook extends Computer{
		public NoteBook(String manufacturer, String processor, int ramSize,
			int diskSize, double processorSpeed) {
		super(manufacturer, processor, ramSize, diskSize, processorSpeed);
		// TODO Auto-generated constructor stub
		this.height = 12.5;
		this.weight = 10.2;
		this.width = 10.0;
	}
		private double height;
		private double width;
		private double weight;
		
		public double screenSize(){
			return height * width;
		}

		@Override
		public String toString() {
			return "NoteBook [height=" + height + ", width=" + width
					+ ", weight=" + weight + ", screenSize =" + screenSize()
					+ ", getRamSize =" + getRamSize() + ", DiskSize = "
					+ getDiskSize() + " ProcessorSpeed ="
					+ getProcessorSpeed() + ", computePower = "
					+ computePower()  + "]";
		}
		
}
public class Driver{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Computer("DELL", "INTEL", 2, 500, 2.5));
		System.out.println(new NoteBook("SAMSUNG", "INTEL", 4, 8, 2.8));
	}
}

/*OUTPUT:
	Driver [manufacturer=DELL, processor=INTEL, ramSize=2, diskSize=500, processorSpeed=2.5]
NoteBook [height=12.5, width=10.0, weight=10.2, screenSize =125.0, getRamSize =4, DiskSize = 8 ProcessorSpeed =2.8, computePower = 11.2]
*/
