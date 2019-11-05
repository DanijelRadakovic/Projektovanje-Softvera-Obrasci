package bank.service;

import java.io.File;
import java.io.IOException;

public interface JSONStream<T> {

    T read(File file) throws IOException;
    void write(T t, File file) throws IOException;
}
