package org.faina.backingpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ReadXMLToObj {
    private final static Logger log = LoggerFactory.getLogger(ReadXMLToObj.class);
    private final String folder;
    private final String fileName;
    private final String content;

    public ReadXMLToObj(String folder, String fileName) throws IOException {
        this.folder = folder;
        this.fileName = fileName;
        content = readFileContent();
        log.info("{} was read", fileName);
    }

    private String readFileContent() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(folder + fileName));
        StringBuilder content = new StringBuilder();
        String curLine;
        while ((curLine = bufferedReader.readLine()) != null) {
            content.append(curLine);
        }
        bufferedReader.close();
        return content.toString();
    }

    public Order toObject() throws JAXBException {
        File file = new File("D:\\MW\\outxml\\state-returned.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Order question = (Order) jaxbUnmarshaller.unmarshal(file);
        System.out.println(question.getOrder_id());
        return question;
    }


}
