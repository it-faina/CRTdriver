package org.faina.runner;

import org.faina.backingpack.Item;
import org.faina.backingpack.Order;
import org.faina.backingpack.ReadXMLToObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

public class AppStartAsAdmin {

    public static void main(String[] args) throws InterruptedException, IOException, JAXBException {
        final Logger log = LoggerFactory.getLogger(AppStartAsAdmin.class);
        boolean doOrder = false;  //change this to false in case of doing doReturn
        String incomingFolder = "D:\\MW\\entryjson\\";  //default folder for pick ups files
        String outgoingFolder = "D:\\MW\\outxml\\";     //default outgoing folder
        String name = "state-fulfilled" + ".xml";                 //default file name
        ReadXMLToObj readXMLToObj = new ReadXMLToObj(outgoingFolder, name);
        Order myOrdered = readXMLToObj.toObject();
        System.out.println(myOrdered.getState());
        String searchedOrderID=myOrdered.getOrder_number();
        System.out.println(searchedOrderID);
        ArrayList<Item> myItem = myOrdered.getItems();
        String ean="";
        for (Item i : myItem
        ) {
             ean =i.getEan();
            System.out.println(ean);
        }


        log.info("wgrany plik");
        System.out.println("kontrola");


        StartPage crtPage = new StartPage();

        SecondPage secondPage = crtPage.loginAsAdmin();

        secondPage.showTopic();
        secondPage.clickOkCookies();

        if (doOrder) {

//            secondPage.clickSearchButton(orderID);

            secondPage.getOrderIDtoPicking();

        } else {
            AllOrdersPage allOrdersPage = secondPage.clickAllOrders();
            log.info(searchedOrderID);
            allOrdersPage.clickSearchButton(searchedOrderID);
//            allOrdersPage.clickViewHistoryButton();
            log.info(ean);
            allOrdersPage.readEANfromSectionOrder(ean);
//            allOrdersPage.clickReturnButton();
//            allOrdersPage.returnReason("5. Arrived too late");
            allOrdersPage.clickCancel();
        }
        System.out.println("stopped");
        crtPage.stopWebDriver();
    }
}
