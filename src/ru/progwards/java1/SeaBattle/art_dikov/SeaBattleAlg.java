package ru.progwards.java1.SeaBattle.art_dikov;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

import java.util.Arrays;

public class SeaBattleAlg {
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    // игровое поле
    private char[][] field;
    // количество попаданий
    private int hits;

    // сделать выстрел
    private void makeShot(int x, int y, SeaBattle seaBattle) {
        SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
        if (fireResult == FireResult.MISS) {
            field[y][x] = '.';
        } else {
            field[y][x] = 'X';
            drawCornerDots(x, y, seaBattle.getSizeX());
            if (fireResult == FireResult.DESTROYED) {
                hits++;
                drawOneDot(x, y - 1, seaBattle.getSizeX());
                drawOneDot(x, y + 1, seaBattle.getSizeX());
                drawOneDot(x - 1, y, seaBattle.getSizeX());
                drawOneDot(x + 1, y, seaBattle.getSizeX());
            } else {
                hits += finishBoat(x, y, seaBattle);
            }
        }
    }

    //добивает корабль и возвращает размер сбитого корабля
    private int finishBoat(int x, int y, SeaBattle seaBattle) {
        int boatLength = 1;
        // если корабль вдоль оси Х
        for (int j = -1; j < 2; j += 2) {
            for (int i = 1; i < 4; i++) {
                int xCoord = x + i * j;
                if (xCoord >= 0 && xCoord < seaBattle.getSizeX()) {
                    if (field[y][xCoord] == ' ') {
                        SeaBattle.FireResult fireHurtShipResult = seaBattle.fire(xCoord, y);
                        if (fireHurtShipResult == FireResult.MISS) {
                            field[y][xCoord] = '.';
                            break;
                        } else {
                            field[y][xCoord] = 'X';
                            drawCornerDots(xCoord, y, seaBattle.getSizeX());
                            drawOneDot(xCoord, y - 1, seaBattle.getSizeX());
                            drawOneDot(xCoord, y + 1, seaBattle.getSizeX());
                            boatLength++;
                            if (fireHurtShipResult == FireResult.DESTROYED) {
                                drawOneDot(xCoord + j, y, seaBattle.getSizeX());
                                drawOneDot(xCoord - j * boatLength, y, seaBattle.getSizeX());
                                return boatLength;
                            }
                        }
                    }
                }
            }
        }
        // если корабль вдоль оси Y
        for (int j = -1; j < 2; j += 2) {
            for (int i = 1; i < 4; i++) {
                int yCoord = y + i * j;
                if (yCoord >= 0 && yCoord < seaBattle.getSizeY()) {
                    if (field[yCoord][x] == ' ') {
                        SeaBattle.FireResult fireHurtShipResult = seaBattle.fire(x, yCoord);
                        if (fireHurtShipResult == FireResult.MISS) {
                            field[yCoord][x] = '.';
                            break;
                        } else {
                            field[yCoord][x] = 'X';
                            drawCornerDots(x, yCoord, seaBattle.getSizeY());
                            drawOneDot(x - 1, yCoord, seaBattle.getSizeY());
                            drawOneDot(x + 1, yCoord, seaBattle.getSizeY());
                            boatLength++;
                            if (fireHurtShipResult == FireResult.DESTROYED) {
                                drawOneDot(x, yCoord + j, seaBattle.getSizeX());
                                drawOneDot(x, yCoord - j * boatLength, seaBattle.getSizeX());
                                return boatLength;
                            }
                        }
                    }
                }
            }
        }
        return boatLength;
    }

    // рисует точки по углам ячейки
    private void drawCornerDots(int x, int y, int size) {
        for (int j = -1; j < 2; j += 2) {
            for (int i = -1; i < 2; i += 2) {
                drawOneDot(x + i, y + j, size);
            }
        }
    }

    private void drawOneDot(int x, int y, int size) {
        if (y >= 0 && x >= 0 && y < size && x < size)
            field[y][x] = '.';
    }

    private void drawField() {
        for (char[] row : field
        ) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------");
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], ' ');
        }

        hits = 0;

        //Стреляем в центральную часть поля размером 4х4, т.к. это наиболее вероятная зона размещения кораблей
        makeShot(4,3,seaBattle);
        if (field[4][3] == ' ') {
            makeShot(3, 4, seaBattle);
        }
        makeShot(5,6,seaBattle);
        if (field[5][6] == ' ') {
            makeShot(6, 5, seaBattle);
        }
        int xx = 6;
        int yy = 3;
        for (int i = 0; i < 4; i++) {
            if (field[yy][xx] == ' ') {
                makeShot(xx, yy, seaBattle);
            }
            xx--;
            yy++;
        }

        // затем стреляем по всему игровому полю начиная с 0-й строки.
        // Сначала стреляем с шагом 4, чтобы найти 4-х палубный
        // Затем уменьшаем шаг, чтобы найти 3-х, 2-х палубные
        // Стреляем по диагоналям
        // Пример выстрелов для поиска 4-х палубного (для 3-х и 2-х палубных аналогично; для 1-палубных перебираем все клетки)
        //           0 1 2 3 4 5 6 7 8 9    координата x
        //         0|.|.|.|X|.|.|.|X|.|.|
        //         1|.|.|X|.|.|.|X|.|.|.|
        //         2|.|X|.|.|.|X|.|.|.|X|
        //         3|X|.|.|.|X|.|.|.|X|.|
        //         4|.|.|.|X|.|.|.|X|.|.|
        //         5|.|.|X|.|.|.|X|.|.|.|
        //         6|.|X|.|.|.|X|.|.|.|X|
        //         7|X|.|.|.|X|.|.|.|X|.|
        //         8|.|.|.|X|.|.|.|X|.|.|
        //         9|.|.|X|.|.|.|X|.|.|.|

        int stepSize = 4; // шаг выстрелов по оси Х
        int stepSizeDecrement = 0; //
        // первый проход цикла while - ищем 4-х палубный,
        // второй проход цикла - ищем 3-х и 2-х палубные, третий 1-палубные
        while (stepSize > 0) {
            int startX = -1 + stepSize - stepSizeDecrement;
            startX = startX > 0 ? startX : 0;
            for (int y = 0; y < seaBattle.getSizeY(); y++) {
                for (int x = startX; x < seaBattle.getSizeX(); x += stepSize) {
                    if (field[y][x] == ' ') {
                        makeShot(x, y, seaBattle);
                        if (hits >= 20) {
                            return;
                        }
                    }
                }
                startX--;
                startX = startX >= 0 ? startX : stepSize - 1;
            }
            stepSize -= stepSizeDecrement;
            stepSizeDecrement += 2;
        }
    }

    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
        System.out.println(seaBattle);
    }
}