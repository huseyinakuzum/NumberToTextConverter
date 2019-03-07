package com.numbertotext.util;

import com.numbertotext.model.Chunk;
import com.numbertotext.model.Coefficient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChunkConverterTest {

    private ChunkConverter testClass;
    @Before
    public void setUp() {
        testClass = new ChunkConverter();
    }
    @Test
    public void chunkTextToNumber() {
        assertEquals(Long.valueOf(121000000000L), java.util.Optional.ofNullable(testClass.ChunkTextToNumber("one hundred twenty one billion")).orElse(null));
        assertEquals(Long.valueOf(1000), java.util.Optional.ofNullable(testClass.ChunkTextToNumber("one thousand")).orElse(null));
        assertEquals(Long.valueOf(21), java.util.Optional.ofNullable(testClass.ChunkTextToNumber("twenty one")).orElse(null));
    }

    @Test
    public void chunkNumberToText() {

        Chunk c = new Chunk((long) 1e9, new Coefficient(1,2,1));
        assertEquals("one hundred twenty one billion", testClass.ChunkNumberToText(c));
        c = new Chunk((long) 100, new Coefficient(0,2,1));
        assertEquals("twenty one", testClass.ChunkNumberToText(c));
        c = new Chunk((long) 1000, new Coefficient(0,0,1));
        assertEquals("one thousand", testClass.ChunkNumberToText(c));

    }
}