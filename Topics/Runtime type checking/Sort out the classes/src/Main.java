import java.util.ArrayList;
import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        for (int i = 0; i < array.length; i++) {
            Shape s = array[i];
            if (s.getClass() == Square.class) {
                squares.add((Square) s);
            } else if (s.getClass() == Circle.class) {
                circles.add((Circle) s);
            }else if (s.getClass() == Polygon.class) {
                polygons.add((Polygon) s);
            }else if(s.getClass()==Shape.class) {
                shapes.add(s);
            }
        }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }
// class Tesing {
//    public static void main(String[] args) {
//        Shape[] array = {new Shape(), new Shape(), new Polygon(), new Circle(), new Square(), new Polygon()};
//        List<Shape> shapes = new ArrayList<>();
//        List<Polygon> polygons = new ArrayList<>();
//        List<Square> squares = new ArrayList<>();
//        List<Circle> circles = new ArrayList<>();
//        Sort.sortShapes(array, shapes, polygons, squares, circles);
//
//        System.out.println(polygons);
//        System.out.println(squares);
//        System.out.println(shapes);
//        System.out.println(circles);
//    }
//}
/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        for (Shape s : array
        ) {
            shapes.add(s);
            if (s.getClass() == Square.class) {
                squares.add((Square) s);
                polygons.add((Polygon) s);
            } else if (s.getClass() == Polygon.class) {
                polygons.add((Polygon) s);
            } else if (s.getClass() == Circle.class) {
                circles.add((Circle) s);
            }
        }
    }
}

//Don't change classes below
class Shape {
}

class Polygon extends Shape {
    int number;

    @Override
    public String toString() {
        return "Polygon{" +
                "number=" + number +
                '}';
    }

    public Polygon(int number) {
        this.number = number;
    }
}

class Square extends Polygon {
    int number;

    @Override
    public String toString() {
        return "Square{" +
                "number=" + number +
                '}';
    }

    public Square(int number) {
        super(10);
        this.number = number;
    }
}

class Circle extends Shape {
    int number;

    @Override
    public String toString() {
        return "Circle{" +
                "number=" + number +
                '}';
    }

    public Circle(int number) {
        this.number = number;
    }
}

class Test {
    public static void main(String[] args) {
        Shape[] arrayOfShapes = new Shape[6];

        arrayOfShapes[0] = new Circle(1);
        arrayOfShapes[1] = new Circle(2);
        arrayOfShapes[2]= new Square(1);
        arrayOfShapes[3]= new Square(2);
        arrayOfShapes[4]= new Polygon(1);
        arrayOfShapes[5]= new Polygon(2);

        List<Shape> shapes = new ArrayList<>();
        List<Polygon> polygons= new ArrayList<>();;
        List<Square> squares= new ArrayList<>();;
        List<Circle> circles= new ArrayList<>();;



        sortShapes(arrayOfShapes,shapes,polygons,squares,circles);
        System.out.println("shapes      "+shapes);
        System.out.println("polygons      "+polygons);
        System.out.println("squares      "+ squares);
        System.out.println("circles      "+circles);

    }
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        for (Shape s : array
        ) {
            shapes.add(s);
            if (s.getClass() == Square.class) {
                squares.add((Square) s);
                polygons.add((Polygon) s);
            } else if (s.getClass() == Polygon.class) {
                polygons.add((Polygon) s);
            } else if (s.getClass() == Circle.class) {
                circles.add((Circle) s);
            }
        }

    }
}*/