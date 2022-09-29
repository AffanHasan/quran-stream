/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quran.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * // TODO comments
 * 
 * @author Affan Hasan
 */
public class DefaultQuranStream implements QuranStream {

    @Override
    public Set<String> getAllSurahNames() {
        final Set<String> surahNames = new HashSet<>(114);
        try {
            final XMLStreamReader xMLStreamReader = XMLInputFactory.newInstance() //
                .createXMLStreamReader(
                        new FileInputStream(
                        getClass() //
                                .getClassLoader() //
                                .getResource ("quran-meta-data.xml") //
                                .getFile()
                        )
                );
            while(xMLStreamReader.hasNext()) {
                if (xMLStreamReader.next() == XMLStreamConstants.START_ELEMENT && 
                        xMLStreamReader.getName() //
                            .getLocalPart() //
                            .equals("suras")) {
                    while (true) {
                        final int index = xMLStreamReader.next();
                        if (index == XMLStreamConstants.START_ELEMENT && 
                            xMLStreamReader.getName() //
                                .getLocalPart() //
                                .equals("sura")) {
                            surahNames.add(xMLStreamReader.getAttributeValue(null, "name"));
                        } else if (index == XMLStreamConstants.END_ELEMENT && 
                            xMLStreamReader.getName() //
                                .getLocalPart() //
                                .equals("suras")) {
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (final FileNotFoundException | XMLStreamException ex) {
        }
        return surahNames;
    }
    
}
