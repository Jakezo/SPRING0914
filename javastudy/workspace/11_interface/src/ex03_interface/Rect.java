package ex03_interface;

public class Rect implements Shape {

	private int width, height;
	
	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String getName() {
		return "사각형";
	}

	@Override
	public double getArea() {
		return width * height;
	}

}
