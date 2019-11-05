package bank.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CSVStream<T> {

    T readLine() throws IOException;
    List<T> readLines() throws IOException;
    Optional<T> findFirst(Predicate<T> condition) throws IOException;
    void writeLines(List<T> t) throws IOException;
}
