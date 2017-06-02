package com.eric.andrew.eric.a091http02okhttp02xml02sax01;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by eric on 02/06/2017.
 */

public class MyHandler01 extends DefaultHandler {
    String nodeName;
    StringBuilder id,name,version;

    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("id".equals(nodeName)){
            id.append(ch,start,length);
        }else
        if("name".equals(nodeName)){
            name.append(ch,start,length);
        }else
        if("version".equals(nodeName)){
            version.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if("app".equals(localName)){
            Log.i("AAA","id is " + id.toString().trim());
            Log.i("AAA","name is " + name.toString().trim());
            Log.i("AAA","version is " + version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }



    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
