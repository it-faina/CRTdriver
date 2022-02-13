package org.faina.tools;

import org.faina.backingpack.Item;
import org.faina.backingpack.Order;
import org.faina.backingpack.ReadXMLToObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

public class ReturnEanDataPicker {
    final static Logger log = LoggerFactory.getLogger(ReturnEanDataPicker.class);

    public static void dataPicker() throws IOException, JAXBException {
        String incomingFolder = "D:\\MW\\entryjson\\";  //default folder for pick ups files
        String outgoingFolder = "D:\\MW\\outxml\\";     //default outgoing folder
        String name = "state-fulfilled" + ".xml";                 //default file name
        ReadXMLToObj readXMLToObj = new ReadXMLToObj(outgoingFolder, name);
        Order myOrdered = readXMLToObj.toObject();
        System.out.println(myOrdered.getState());
        String searchedOrderID = myOrdered.getOrder_number();
        System.out.println(searchedOrderID);
        ArrayList<Item> myItem = myOrdered.getItems();
        String ean;
        for (Item i : myItem
        ) {
            ean = i.getEan();
            System.out.println(ean);
        }
        log.info("entered file");
    }
}
