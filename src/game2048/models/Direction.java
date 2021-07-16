package game2048.models;

public enum Direction {
    UP(2), DOWN(3), LEFT(0), RIGHT(1), INVALID(4);

    int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public static Direction getDirection(int direction) {
        Direction result;
        switch (direction) {
            case 0:
                result = Direction.LEFT;
                break;
            case 1:
                result = Direction.RIGHT;
                break;
            case 2:
                result = Direction.UP;
                break;
            case 3:
                result = Direction.DOWN;
                break;
            default:
                result = Direction.INVALID;
        }
        return result;
    }

}
