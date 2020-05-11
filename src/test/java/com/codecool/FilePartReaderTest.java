package com.codecool;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader underTest = new FilePartReader();


    @Test
    public void testSetUpHappyPath() {
        // given
        String filePath = "";
        Integer fromLine = 10;
        Integer toLine = 20;
        // when
        // then
        assertDoesNotThrow(() -> underTest.setUp(filePath, fromLine, toLine));
    }

    @Test
    public void testSetUpWithWrongFromLineParameter() {
        // given
        String expectedExceptionMessage = "fromLine should be greater than 1";
        String filePath = "";
        Integer fromLine = 0;
        Integer toLine = 20;

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> underTest.setUp(filePath, fromLine, toLine));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void testSetUpWithWrongFromLineAndToLineParameters() {
        // given
        String expectedExceptionMessage = "toLine should be greater than fromLine";
        String filePath = "";
        Integer fromLine = 10;
        Integer toLine = 8;

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> underTest.setUp(filePath, fromLine, toLine));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

}