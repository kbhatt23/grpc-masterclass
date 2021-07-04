package decorator;

public class DecoratorClient {

	public static void main(String[] args) {
		BaseShape baseShape = new BaseShape();
		RectangleShape rectangleShape = new RectangleShape(baseShape);
		RedShape redShape = new RedShape(rectangleShape);
		
		redShape.draw();
	}
}

//decorator
abstract class ShapeDecorator implements Shape{
	
	private Shape shape;

	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}
	
	
	@Override
	public void draw() {
		shape.draw();
		drawYourShape();
	}

	protected abstract void drawYourShape();
	
}

class RectangleShape extends ShapeDecorator{

	public RectangleShape(Shape shape) {
		super(shape);
	}

	@Override
	protected void drawYourShape() {
		System.out.println("drawing rectangle");
	}

	
}

class RedShape extends ShapeDecorator{

	public RedShape(Shape shape) {
		super(shape);
	}

	@Override
	protected void drawYourShape() {
		System.out.println("filling red color");
	}
	
}

class BaseShape implements Shape{

	@Override
	public void draw() {
		System.out.println("drawing base shape");
	}
	
}