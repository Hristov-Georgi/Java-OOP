package SOLID.logger.interfaces;

public interface File {

    int getSize();
    void append(String text);
    boolean write(String text);
}
