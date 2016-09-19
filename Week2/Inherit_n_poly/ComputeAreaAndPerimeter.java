import java.util.Scanner;

/* @author- Bimal Parajuli
 * @date - 13-09-2016
 */
abstract class Shape{
	private String shapeName;

	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
	public String getShapeName(){
		return this.shapeName;
	}
	abstract double computeArea();
	abstract double computePerimeter();
	abstract void readShapeDate();
	@Override
	public String toString() {
		return "Shape [shapeName=" + shapeName + "]";
	}
}
class Rectangle extends Shape{

	public Rectangle(String shapeName) {
		super(shapeName);
		// TODO Auto-generated constructor stub
		this.width = 0;
		this.height = 0;
	}
	private double width;
	private double height;
	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		return (2 * width + 2 * height);
	}
	@Override
	void readShapeDate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a width: ");
		this.width = sc.nextDouble();
		System.out.println("Enter a height: ");
		this.height = sc.nextDouble();
		sc.close();
	}
	@Override
	public String toString() {
		return "Shape is Rectangle\n[width=" + width + ", height=" + height
				+ "\n The Area is =" + computeArea() + ", \n The Perimeter is="
				+ computePerimeter() + "]";
	}
	
}
class Circle extends Shape
{
	public Circle(String shapeName) {
		super(shapeName);
		// TODO Auto-generated constructor stub
		this.radius = 0;
	}

	private double radius;
	
	@Override
	public String toString() {
		return "Shape is Circle \n[radius=" + radius + " \nThe Area is = " + computeArea()
				+ "\n The Perimeter is=" + computePerimeter() + "]";
	}

	@Override
	double computeArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius *radius;
	}

	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}

	@Override
	void readShapeDate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a radius: ");
		this.radius = sc.nextDouble();
		sc.close();
	}
	
}
class RtTriangle extends Shape{

	public RtTriangle(String shapeName) {
		super(shapeName);
		// TODO Auto-generated constructor stub
	}
	private double base, height;
	@Override
	double computeArea() {
		// TODO Auto-generated method stub
		return 0.5 * base * height;
	}
	@Override
	double computePerimeter() {
		// TODO Auto-generated method stub
		return (base + height + Math.sqrt((base * base) + (height * height)));
	}
	@Override
	void readShapeDate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a height: ");
		this.height = sc.nextDouble();
		System.out.println("Enter a Base: ");
		this.base = sc.nextDouble();
		sc.close();
	}
	@Override
	public String toString() {
		return "Shape is Right Angle Triangle \n [base=" + base + ", height=" + height
				+ "\n The Area is =" + computeArea() + ", \nThe Perimeter is= "
				+ computePerimeter() + "]";
	}
	
}
public class ComputeAreaAndPerimeter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape obj = getShape();
		obj.readShapeDate();
		obj.computeArea();
		obj.computePerimeter();
		System.out.println(obj);
	}
	public static Shape getShape(){
		System.out.println("Enter T for Triangle");
		System.out.println("Enter R for Rectangle");
		System.out.println("Enter C for Circle");
		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
		switch(ch){
		case "T":
			Shape s = new RtTriangle("Triangle");
			return s;
		case "R":
			s = new Rectangle("Rectangle");
			return s;
		case "C":
			s = new Circle("Circle");
			return s;
		default:
				System.out.println("Default");
		}
		return null;
	}
}

