/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package quran.stream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author ahasan
 */
public class QuranStreamTest {
    
    private final QuranStream quranStream = new DefaultQuranStream();
    
    @Test
    public void shouldReturnAll114SurahNames() {
        assertEquals(114, this.quranStream.getAllSurahNames().size());
    }
    
}
