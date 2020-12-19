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

class MyCube {
    void initCube(String[][] Cube) {
        Cube[0] = new String[]{"R", "R", "W"};
        Cube[1] = new String[]{"G", "C", "W"};
        Cube[2] = new String[]{"G", "B", "B"};
    }

    void printCube(String[][] Cube) {
        for (int i = 0; i < Cube.length; i++) {
            for (int j = 0; j < Cube[i].length; j++) {
                System.out.print(Cube[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void getDir(String[] dir) {
        System.out.print("CUBE> ");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        dir = temp.split("");
        for (int i = 0; i < dir.length; i++) {
            String temp1[] = new String[dir.length];
            //temp1[i] = dir[i];
            if (dir[i].equals("'")) {
                temp1[i] = dir[i - 1].concat(dir[i]);
                dir[i - 1] = temp1[i];
            }
        }
        final List<String> list = new ArrayList<String>();
        Collections.addAll(list, dir);
        list.removeIf(n -> (n.equals("'")));
        dir = list.toArray(new String[list.size()]);
        Step2.dir = dir;

        //System.out.println(Arrays.deepToString(dir));

        if (dir[0].equals("Q")) {
            System.out.println("Bye~");
            System.exit(0);
        }
    }

    void MyCal(String[][] Cube, String[] dir) {
        MyCube obj = new MyCube();
        String temp = new String("");
        //System.out.println(Arrays.deepToString(dir));
        //obj.printCube(Step2.Cube);
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].equals("U")) {
                System.out.printf("%s%n", dir[i]);
                for (int j = 0; j < 2; ++j) { // 12/13일 - for문이 작동을 안함
                    temp = Step2.Cube[0][j + 1];
                    Step2.Cube[0][j] = temp;
                    System.out.println(j);
                    if (j + 1 == 2) {
                        temp = Step2.Cube[0][0];
                        Step2.Cube[0][j + 1] = temp;
                    }
                }
                obj.printCube(Step2.Cube);
            }

            if (dir[i].equals("U'")) {
                System.out.printf("%s%n", dir[i]);
                for (int j = 0; j < 3; j++) {
                    temp = Step2.Cube[0][2 - j];          // R R W -> W R R ( 0 1 2 -> 2 1 0 ) 2 0 1 로 만들어야
                    if (j == 1) {
                        temp = Step2.Cube[0][j];
                        System.out.println(temp);
                        Step2.Cube[0][j + 1] = temp;
                    } else {
                        Step2.Cube[0][j] = temp;
                        System.out.println(j);
                    }
                }
                obj.printCube(Step2.Cube);
            }

        }
    }
}
