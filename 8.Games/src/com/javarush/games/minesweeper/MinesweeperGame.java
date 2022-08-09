package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
            return;
        }

        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }

        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private void countMineNeighbors() {
        for (GameObject[] row : gameField) {
            for (GameObject cell : row) {
                if (!cell.isMine) {
                    List<GameObject> neighbors = getNeighbors(cell);
                    for (GameObject neighbor : neighbors) {
                        if (neighbor.isMine) {
                            cell.countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void openTile(int x, int y) {
        if (isGameStopped) {
            return;
        }

        GameObject currentCell = gameField[y][x];
        if (!currentCell.isOpen && !currentCell.isFlag) {
            currentCell.isOpen = true;
            setCellColor(currentCell.x, currentCell.y, Color.GRAY);
            countClosedTiles--;

            if (currentCell.isMine) {
                setCellValueEx(currentCell.x, currentCell.y, Color.RED, MINE);
                gameOver();
            } else {
                if (currentCell.countMineNeighbors == 0) {
                    for (GameObject neighbor : getNeighbors(currentCell)) {
                        if (!neighbor.isOpen) {
                            openTile(neighbor.x, neighbor.y);
                        }
                    }
                    setCellValue(x, y, "");
                } else {
                    setCellNumber(x, y, currentCell.countMineNeighbors);
                }

                score += 5;
                setScore(score);
            }

            if (countClosedTiles == countMinesOnField && !currentCell.isMine) {
                win();
            }
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped) {
            return;
        }

        GameObject currentCell = gameField[y][x];
        if (!currentCell.isOpen && (currentCell.isFlag || countFlags != 0)) {
            currentCell.isFlag = !currentCell.isFlag;
            countFlags += currentCell.isFlag ? -1 : +1;
            setCellColor(x, y, currentCell.isFlag ? Color.YELLOW : Color.ORANGE);
            setCellValue(x, y, currentCell.isFlag ? FLAG : "");
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Игра окончена!", Color.BLACK, 32);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Вы выиграли!", Color.BLACK, 32);
    }
}