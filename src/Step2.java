import java.util.*;

public class Step2 {
    public static String[][] Cube = new String[3][];
    public static String[] dir;

    public static void main(String args[]) {
        MyCube obj = new MyCube();
        obj.initCube(Cube);
        obj.printCube(Cube);
        while (true) {
            obj.getDir(dir);
            //System.out.println(Arrays.deepToString(Step2.dir));
            obj.MyCal(Cube, dir);
        }
    }
}

