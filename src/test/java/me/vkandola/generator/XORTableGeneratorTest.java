package me.vkandola.generator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class XORTableGeneratorTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errStream = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outStream));
        System.setErr(new PrintStream(errStream));
    }

    @Test
    public void test__can_instantiate_without_errors() {
        XORTableGenerator tg = new XORTableGeneratorBuilder()
                .build();

        assertEquals("", outStream.toString());
        assertEquals("", errStream.toString());
    }

    @After
    public void cleanup() {
        System.setOut(null);
        System.setErr(null);
    }
}
