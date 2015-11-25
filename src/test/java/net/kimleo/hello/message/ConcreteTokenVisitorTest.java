package net.kimleo.hello.message;

import net.kimleo.hello.validate.Validator;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ConcreteTokenVisitorTest {

    public static final String HELLO_TOKEN = "hello";
    private ConcreteTokenVisitor visitor;
    private PrintStream stream;
    private Validator<String> validator;

    @Before
    public void setUp() throws Exception {
        stream = mock(PrintStream.class);
        validator = mock(Validator.class);
        visitor = new ConcreteTokenVisitor();
        when(validator.validate(anyString())).thenReturn(true);
    }

    @Test
    public void should_print_to_stream() throws Exception {
        visitor.withStream(stream).visit(HELLO_TOKEN);

        verify(stream).println(HELLO_TOKEN);
    }
}