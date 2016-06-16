
interface Shape {
	void draw();
}

class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("drawing rectangle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("drawing square");
	}
}

class ShapeFactory {
	Shape getShape(String shape) {
		if (shape == null)
			return null;
		if (shape.equalsIgnoreCase("rectangle"))
			return new Rectangle();
		if (shape.equalsIgnoreCase("square"))
			return new Square();
		return null;
	}
}

public class Factory {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("rectangle");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("square");
		shape2.draw();
	}
}
