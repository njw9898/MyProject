package com.example.to_do_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class Parser {

	XmlPullParser parser = null;

	public List Parsing (InputStream in) throws XmlPullParserException, IOException {

		String tempTitle=null;
		String tempDate=null;
		String tempContent=null;
		String tempLevel=null;
		List entries = new ArrayList();
		
		XmlPullParserFactory xmlFactory = XmlPullParserFactory.newInstance();

		parser = xmlFactory.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(in, null);
		parser.nextTag();

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {

			switch (eventType) {

			case XmlPullParser.START_TAG :
				if ( parser.getName().equals("task")) {
					tempTitle = "";
					tempDate = "";
					tempLevel = "";
					tempContent = "";
				}
				else if ( parser.getName().equals("title")) {
					parser.next();
					tempTitle = parser.getText();
					parser.nextToken();
				}
				else if ( parser.getName().equals("dueDate")) {
					parser.next();
					tempDate = parser.getText();
					parser.nextToken();
				}
				else if ( parser.getName().equals("level")) {
					parser.next();
					tempLevel = parser.getText();
					parser.nextToken();
				}
				else if ( parser.getName().equals("content")) {
					parser.next();
					tempContent = parser.getText();
					parser.nextToken();
				}
				break;
			case XmlPullParser.END_TAG:
				if (parser.getName().equals("task")) {
					entries.add(new Entry(tempTitle, tempDate, tempLevel, tempContent));
				}
				break;
			}

			eventType = parser.next();
		}
		return entries;
	}
	
}