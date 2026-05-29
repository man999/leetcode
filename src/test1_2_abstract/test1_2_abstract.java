import java.util.ArrayList;

abstract class Shape {
    public abstract double getVolume();
}


abstract class SolidOfRevolution extends Shape {
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Pyramid extends Shape {
    private double square;
    private double height;

    public Pyramid(double square, double height) {
        this.square = square;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return square * height * 4 / 3;
    }
}

class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Box extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;
    private double volume;

    public Box(double available) {
        this.available = available;
        this.volume = available;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double getVolume() {
        return volume;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}

void main() {
    Ball ball = new Ball(4.5);
    Cylinder cylinder = new Cylinder(2, 2);
    Pyramid pyramid = new Pyramid(100, 100);

    Box box = new Box(600);

    System.out.println("box  volume is " + box.getVolume());
    System.out.println("ball volume is " + ball.getVolume());
    System.out.println(box.add(ball));
    System.out.println("cylinder volume is " + cylinder.getVolume());
    System.out.println(box.add(cylinder));
    System.out.println("pyramig volume is " + pyramid.getVolume());
    System.out.println(box.add(pyramid));
}
