package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.environment.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(int level) {
        String fileName;
        if (level == 1) fileName = "/map.txt";
        else fileName = "/map2.txt";
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'C':
                            cell.setType(CellType.FLOOR);
                            new Cat(cell);
                            break;
//                        case '@':
//                            cell.setType(CellType.FLOOR);
////                            map.setPlayer(new Player(cell));
//                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Cheese(cell);
                            break;
                        case 'G':
                            cell.setType(CellType.FLOOR);
                            new Ghost(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new GardenKey(cell);
                            break;
                        case 'K':
                            cell.setType(CellType.FLOOR);
                            new CellarKey(cell);
                            break;
                        case 'W':
                            cell.setType(CellType.FLOOR);
                            new Wife(cell);
                            break;
                        case '+':
                            cell.setType(CellType.FLOOR);
                            new Grass(cell);
                            map.raiseGrassCounter();
                            break;
                        case '-':
                            cell.setType(CellType.FLOOR);
                            new CuttedGrass(cell);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Apple(cell);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Meat(cell);
                            break;
                        case 'w':
                            cell.setType(CellType.WALL);
                            new SpiderWeb(cell);
                            break;
                        case 'x':
                            cell.setType(CellType.WALL);
                            new Bones(cell);
                            break;
                        case 't':
                            cell.setType(CellType.FLOOR);
                            new Torch(cell);
                            break;
                        case 'l':
                            cell.setType(CellType.WALL);
                            new Lamp(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new LightBulb(cell);
                            break;
                        case 'o':
                            cell.setType(CellType.DOOR);
                            new CellarDoor(cell);
                            break;
                        case 'O':
                            cell.setType(CellType.DOOR);
                            new GardenDoor(cell);
                            break;
                        case 'f':
                            cell.setType(CellType.WALL);
                            new Fence(cell);
                            break;
                        case 'F':
                            cell.setType(CellType.FLOOR);
                            new Gate(cell);
                            break;
                        case 'đ':
                            cell.setType(CellType.WALL);
                            new Toilet(cell);
                            break;
                        case '×':
                            cell.setType(CellType.WALL);
                            new Tub(cell);
                            break;
                        case 'Đ':
                            cell.setType(CellType.WALL);
                            new Bed(cell);
                            break;
                        case 'T':
                            cell.setType(CellType.WALL);
                            new Tv(cell);
                            break;
                        case '1':
                            cell.setType(CellType.WALL);
                            new Sofa1(cell);
                            break;
                        case '2':
                            cell.setType(CellType.WALL);
                            new Sofa2(cell);
                            break;
                        case 'ß':
                            cell.setType(CellType.WALL);
                            new Window(cell);
                            break;
                        case '<':
                            cell.setType(CellType.STAIR);
                            new StairUp(cell);
                            break;
                        case '>':
                            cell.setType(CellType.STAIR);
                            new StairDown(cell);
                            break;
                        case '3':
                            cell.setType(CellType.WALL);
                            new Cross1(cell);
                            break;
                        case '4':
                            cell.setType(CellType.WALL);
                            new Cross2(cell);
                            break;
                        case 'B':
                            cell.setType(CellType.WALL);
                            new Book(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.WALL);
                            new Mirror(cell);
                            break;
                        case '$':
                            cell.setType(CellType.FLOOR);
                            new Bread(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Pear(cell);
                            break;
                        case 'r':
                            cell.setType(CellType.FLOOR);
                            new Carrot(cell);
                            break;
                        case '&':
                            cell.setType(CellType.FLOOR);
                            new Ring(cell);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            new Scrub(cell);
                            break;
                        case '7':
                            cell.setType(CellType.WALL);
                            new Ufo(cell);
                            break;
                        case '8':
                            cell.setType(CellType.WALL);
                            new Beam(cell);
                            break;
                        case '9':
                            cell.setType(CellType.WALL);
                            new Cow(cell);
                            break;
                        case '€':
                            cell.setType(CellType.FLOOR);
                            new Knife(cell);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }
}
