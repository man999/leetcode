import java.util.ArrayList;

interface Shape extends Comparable<Shape> {
    double getVolume();

    @Override
    default int compareTo(Shape other) {
        return Double.compare(getVolume(), other.getVolume());
    }
}

abstract class SolidOfRevolution implements Shape {
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Pyramid implements Shape {
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

class Box implements Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;
//    private double volume;

    public Box(double available) {
        this.available = available;
//        this.volume = available;
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
//        return volume;
        return available;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}

class SolidRevolutionForFunction extends SolidOfRevolution {
    private Function<Double, Double> function;
    private double a;
    private double b;

    public SolidRevolutionForFunction(Function<Double, Double> function, double a, double b) {
        super(b - a);
        this.function = function;
        this.a = a;
        this.b = b;
    }

    @Override
    public double getVolume() {
        double sum = 0;
        int iterations = 10_000;
        double delta = (b - a) / iterations;
        for (int i = 0; i < iterations; i++) {
            double x = a + ((b - a) * i / iterations);
            sum += Math.pow(function.apply(x), 2) * delta;
        }
        return Math.PI * sum;
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

    ArrayList<Shape> shapes = box.getShapes();
    Collections.sort(shapes);
    System.out.println(shapes);

    Shape shape = new SolidRevolutionForFunction(new Function<Double, Double>() {

        @Override
        public Double apply(Double x) {
            return Math.cos(x);
        }
    }, 0, 10);
    System.out.println(shape.getVolume());
}
