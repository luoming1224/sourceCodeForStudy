package basicstudy;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = null;
        Optional<User> opt = Optional.of(user);
    }
}
