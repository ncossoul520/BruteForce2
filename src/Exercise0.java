import java.util.ArrayList;

public class Exercise0 {
    public static void RunB() {
        Point target = new Point(250, 250);
        ArrayList<Point> points = makeRandomPointList(1000, 0, 0, 500, 500);
        Point furthest = Point.findFurthestFrom(target, points);
        System.out.println("Furtest point from " + target.toString() + ": " + furthest.toString());
    }

    private static ArrayList<Point> makeRandomPointList(int num, int x_min, int y_min, int x_max, int y_max) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int x = (int)(x_min + Math.random() * (x_max - x_min));
            int y = (int)(y_min + Math.random() * (y_max - y_min));
            Point p = new Point(x, y);
            points.add( p );
        }
        return points;
    }


    //********************
    public static void RunC(int rows, int cols) {
        int[][] elevations = Array2DRand(rows, cols, 50, 2000);
        ArrayList<Point> points = makeRandomPointList(1000, 0, 0, cols, rows);
        Point highest = findHighestPoint(points, elevations);
        System.out.println("Highest point:" + highest.toString() + " (" + elevations[ highest.getY() ][ highest.getX() ] + "m)");
    }

    private static int[][] Array2DRand(int rows, int cols, int min, int max) {
        int[][] arr = new int[rows][cols];
        int val, val_max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                val = (int)( Math.random()*(max - min) + min );
                arr[r][c] = val;
                if (val > val_max) {
                    val_max = val;
                }
            }
        }
//        System.out.println("[DEBUG] val_max=" + val_max);
        return arr;
    }

    private static Point findHighestPoint(ArrayList<Point> points, int[][] elevations) {
        Point highest = new Point();
        int elevation_max = 0, elevation;
        for (Point point : points) {
            elevation = elevations[ point.getY() ][ point.getX() ];
            if ( elevation > elevation_max ) {
                highest = point;
                elevation_max = elevation;
            }
        }
        return highest;
    }
}
