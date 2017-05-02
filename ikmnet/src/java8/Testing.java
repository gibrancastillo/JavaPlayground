package java8;

public class Testing {

	public static void main(String[] args) {
		Shape shape;
		/*Circle circle = new Circle();
		shape = (Shape) circle;
		shape.drawShape();
		
		Shape square = new Shape();
		shape = (Shape) square;
		shape.drawShape();
		
		shape = new Square();
		shape.drawShape();
		
		shape = new Shape();
		((Square) shape).drawShape();*/
		
		shape = (Shape) (new Circle());
		shape.drawShape();
	}
}