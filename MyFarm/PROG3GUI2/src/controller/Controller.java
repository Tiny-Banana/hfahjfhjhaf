package controller;

public interface Controller {
    boolean isRequestingUp();
    boolean isRequestingDown();
    boolean isRequestingLeft();
    boolean isRequestingRight();
    boolean isRequestingStatus();
    boolean isRequestingClose();
    boolean isRequestingNextDay();
}
