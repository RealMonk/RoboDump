package Main;

import Beings.Player;
import lombok.Getter;

import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Loader {
    @Getter
    private static int[][] world = new int[50][50];


    static public int[][] getMap() {

        System.out.println("Loading map");

        Scanner sc = new Scanner(Loader.class.getResourceAsStream("/levels/world01.txt"));
        while (sc.hasNext()) {
            for (int y = 0; y < 50; y++) {
                System.out.println();
                String[] str = sc.nextLine().split(" ");
                for (int x = 0; x < 50; x++) {
                    world[y][x] = Integer.parseInt(str[x]);
                    System.out.print(world[y][x]);
                }
            }
        }
        //TODO Load objects, return objects[][]
        System.out.println();
        System.out.println("Finished loading map");
        return world;

    }
}