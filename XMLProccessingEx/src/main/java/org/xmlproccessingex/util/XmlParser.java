package org.xmlproccessingex.util;

import jakarta.xml.bind.JAXBException;

public interface XmlParser {

    <E> E parse(Class <E> clazz, String path) throws JAXBException;
}
