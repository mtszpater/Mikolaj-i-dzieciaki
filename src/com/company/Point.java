package com.company;

/**
 * author @pater
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int arg) {
        arg = changeToPointInRange(arg);
        this.x = arg;
    }

    public void setY(int arg) {
        arg = changeToPointInRange(arg);
        this.y = arg;
    }

    private int changeToPointInRange(int arg) {
        if(isBiggerThanBoardSize(arg)) arg = ( arg-1 ) % Configuration.BOARD_SIZE;
        if(isSmallerThanBoardSize(arg)) arg = (arg % Configuration.BOARD_SIZE) + Configuration.BOARD_SIZE;
        if(isInCorner(arg)) arg = 0;
        
        return arg;
    }

    private boolean isBiggerThanBoardSize(int arg) {
        return arg > Configuration.BOARD_SIZE;
    }

    private boolean isSmallerThanBoardSize(int arg) {
        return arg < Configuration.BOARD_START;
    }

    private boolean isInCorner(int arg) {
        return arg == Configuration.BOARD_SIZE;
    }
}
