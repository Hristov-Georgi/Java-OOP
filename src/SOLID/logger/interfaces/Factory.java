package SOLID.logger.interfaces;

public interface Factory<T> {

    T produce(String inputData);
}
