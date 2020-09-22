package xml_parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

	public void XmlParser() {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			sp.parse("xmlfile.xml", new SaxHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class SaxHandler extends DefaultHandler {

		private String tagname = "";
		OutputStreamWriter out = null;

		@Override
		public void startDocument() throws SAXException {
			try {
				out = new OutputStreamWriter(new FileOutputStream("resultfile.csv"), "GBK");
				trydemo();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void endDocument() throws SAXException {
			try {
				out.close();
				System.out.println("CSV file is created Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			this.tagname = qName;
			if (attributes.getLength() > 0) {
				try {
					out.write(attributes.getValue(0) + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			this.tagname = "";
			if (qName.equalsIgnoreCase("book")) {
				try {
					out.write("\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		public void trydemo() {
			try {
				out.write("ID" + ",");
				out.write("Author" + ",");
				out.write("Title" + ",");
				out.write("Genre" + ",");
				out.write("Price" + ",");
				out.write("Publish Date" + ",");
				out.write("Description" + "," + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if (this.tagname.equals("author")) {
				try {
					String str = new String(ch, start, length);
					str = str.replaceAll("[^a-zA-Z0-9]", " ");
					out.write(str + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (this.tagname.equals("title")) {
				try {
					out.write(new String(ch, start, length) + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (this.tagname.equals("genre")) {
				try {
					out.write(new String(ch, start, length) + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (this.tagname.equals("price")) {
				try {
					out.write(new String(ch, start, length) + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (this.tagname.equals("publish_date")) {
				try {
					out.write(new String(ch, start, length) + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (this.tagname.equals("description")) {
				try {
					String str = new String(ch, start, length);
					str = str.replaceAll("[^a-zA-Z0-9]", " ");
					out.write(str + ",");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
