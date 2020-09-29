import java.util.ArrayList;

public class Exercise2 {
    private static final int TOWER_RADIUS = 50;
    private static final int TOWER_NUM    = 10;
    private static final int MAP_XMAX     = 100;
    private static final int MAP_YMAX     = 100;

    private static ArrayList<Point> towerList = new ArrayList<>();
    private static int[][] map;


    public static void Run() {
        map = new int[MAP_XMAX][MAP_YMAX];
        addRandomTowers(50);
        boolean covered = isCovered( towerList, 0, 0, 100, 100);
        displayMap();
        System.out.println( covered );
    }

    private static void addRandomTowers(int i) {
        for (int tower = 0; tower < TOWER_NUM; tower++) {
            Point p = new Point( randomInt(0, MAP_XMAX), randomInt(0, MAP_YMAX));
            towerList.add( p );
        }
    }

    private static int randomInt(int min, int max) {
        return (int)(min + Math.random() * (max - min));
    }

    private static boolean isCovered(ArrayList<Point> towerList, int minX, int minY, int maxX, int maxY) {
        boolean res = true;
        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                Point p = new Point(x, y);

                int coverage = 0;
                for (Point tower : towerList) {
                    if ( p.distance( tower ) < TOWER_RADIUS) {
                        if (coverage < 10) {
                            coverage++;
                        }
                        map[x][y] = coverage;
                    }
                }
                if ( coverage == 0) {
                    res = false;
//                    return false;
                }
            }
        }
        return res;
    }

    private static void displayMap() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                System.out.print( map[x][y]);
            }
            System.out.println();
        }
    }
}
