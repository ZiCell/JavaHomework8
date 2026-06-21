import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        System.out.println("--- Исходная матрица ---");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        int angle = 0;
        while (true) {
            System.out.print("\nВведите угол поворота (90, 180, 270): ");
            if (scanner.hasNextInt()) {
                angle = scanner.nextInt();
                if (angle == 90 || angle == 180 || angle == 270) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Введите строго 90, 180 или 270.");
        }

        int[][] rotatedColors = rotateColors(colors, angle);

        System.out.println("\n--- Матрица после поворота на " + angle + "° ---");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateColors(int[][] source, int angle) {
        if (angle == 90) {
            return rotate90(source);
        } else if (angle == 180) {
            return rotate90(rotate90(source));
        } else {
            return rotate90(rotate90(rotate90(source)));
        }
    }

    public static int[][] rotate90(int[][] source) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[j][SIZE - 1 - i] = source[i][j];
            }
        }
        return result;
    }
}
