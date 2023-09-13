package main;

public class InvalidValueException extends Exception {
    public InvalidValueException() {
        super("空の値が渡りました。");
    }
}
