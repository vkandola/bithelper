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

    private void assertNothingPrinted() {
        assertEquals("", outStream.toString());
        assertEquals("", errStream.toString());
    }

    @Test
    public void test__can_instantiate_without_output_or_errors() {
        XORTableGenerator tg = new XORTableGeneratorBuilder()
                .build();

        assertNothingPrinted();
    }

    @Test
    public void test__can_set_XOR_mask() {
        int XORMaskToTest = Integer.MAX_VALUE;
        XORTableGenerator tg = new XORTableGeneratorBuilder()
                .withXORMask(XORMaskToTest)
                .build();

        assertEquals(XORMaskToTest, tg.getXORMask());
        assertNothingPrinted();
    }

    @Test
    public void test__has_sane_default_XOR_mask() {
        XORTableGenerator tg = new XORTableGeneratorBuilder()
                .build();

        assertEquals(0, tg.getXORMask());
        assertNothingPrinted();
    }

    @After
    public void cleanup() {
        System.setOut(null);
        System.setErr(null);
    }
}
