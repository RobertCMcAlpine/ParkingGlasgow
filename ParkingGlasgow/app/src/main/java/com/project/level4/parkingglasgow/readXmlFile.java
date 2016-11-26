/**
 * Created by Matt on 26/11/2016.
 */

package com.project.level4.parkingglasgow;
import com.project.level4.parkingglasgow.R;

import android.content.Context;
import android.util.Log;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class readXmlFile {
    String a = null, b = null, c = null, d = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;


    public void main(Context context) {

        InputStream inputstream;
        try {
            inputstream = context.getResources().openRawResource(
                    R.xml.parkingfeed);
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = xmlFactoryObject.newPullParser();
            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(inputstream, null);
            Log.d("Tag Name", "Before cal");
            parseXMLAndStoreIt(myparser);
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;
       // String a = null, b = null, c = null, d = null;
        try {
            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                String name = myParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (name.equals("name")) {
                            a = text;
                        } else if (name.equals("price")) {
                            b = text;
                        } else if (name.equals("description")) {
                            c = text;
                        } else if (name.equals("calories")) {
                            d = text;
                        } else {
                        }
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("thisworked",a);
    }


}
