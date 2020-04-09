package lesson_2;

public class Lesson_2 {

    private static String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    private static String[][] StringToArr(String str) throws ArrayIndexOutOfBoundsException {
        String[][] arr = new String[4][4];

        if (str.split("\n").length != 4) {
            throw new ArrayIndexOutOfBoundsException("Sting format is out of bounds. Mast be String [i=4][j=4]. You have i != 4. Your current length is "+str.split("\n").length);
        }

        String[] src = str.split("\n");

        for (int i = 0; i < 4 ; i++) {
            if (src[i].split(" ").length != 4) {
                throw new ArrayIndexOutOfBoundsException("Sting format is out of bounds. Mast be String [i=4][j=4]. You have j != 4.Your current length is "+src[i].split(" ").length);
            }
            arr[i] = src[i].split(" ");
        }
        return arr;
    }

    public static float CalcStr(String[][] arr) throws NumberFormatException {
        float val=0f;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    val += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {throw new NaN();}

            }
        }
        return (val)/2;
    }


    public static void main(String[] args) {
        try {
            System.out.println(CalcStr(StringToArr(str)));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

    }



}
