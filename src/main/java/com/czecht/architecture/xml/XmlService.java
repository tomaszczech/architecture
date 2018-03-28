package com.czecht.architecture.xml;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlService {


	public String convertToXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element arrangement = doc.createElement("arrangement");
			doc.appendChild(arrangement);

			// SOURCE
			Element sourceId = doc.createElement("SOURCE");
			sourceId.appendChild(doc.createTextNode("todo"));
			arrangement.appendChild(sourceId);

			Element updatedBy = doc.createElement("UPDATED_BY");
			updatedBy.appendChild(doc.createTextNode("czecht"));
			arrangement.appendChild(updatedBy);

			Element updatedDate = doc.createElement("UPDATED_DATE");
			updatedDate.appendChild(doc.createTextNode(new DateTime().toString()));
			arrangement.appendChild(updatedDate);

			Element caId = doc.createElement("CA_ID");
			caId.appendChild(doc.createTextNode("CAES156"));
			arrangement.appendChild(caId);

			Element status = doc.createElement("STATUS");
			status.appendChild(doc.createTextNode("Draft"));
			arrangement.appendChild(status);

			Element currentVersion = doc.createElement("CURRENT_VERSION");
			currentVersion.appendChild(doc.createTextNode("1"));
			arrangement.appendChild(currentVersion);

			Element caCreatedBy = doc.createElement("CA_CREATED_BY");
			caCreatedBy.appendChild(doc.createTextNode("czecht"));
			arrangement.appendChild(caCreatedBy);

			Element caCreatedDate = doc.createElement("CA_CREATED_DATE");
			caCreatedDate.appendChild(doc.createTextNode(new DateTime().toString()));
			arrangement.appendChild(caCreatedDate);

			Element caUpdatedBy = doc.createElement("CA_UPDATED_BY");
			caUpdatedBy.appendChild(doc.createTextNode("jojo"));
			arrangement.appendChild(caUpdatedBy);

			Element caUpdatedDate = doc.createElement("CA_UPDATED_DATE");
			caUpdatedDate.appendChild(doc.createTextNode(new DateTime().toString()));
			arrangement.appendChild(caUpdatedDate);

			Element caName = doc.createElement("CA_NAME");
			caName.appendChild(doc.createTextNode("caName"));
			arrangement.appendChild(caName);

			Element indication = doc.createElement("INDICATION");
			indication.appendChild(doc.createTextNode("indication"));
			arrangement.appendChild(indication);

//			Element payers = doc.createElement("PAYERS");
//			arrangement.appendChild(payers);
			doc = addPayers(doc, arrangement, "Ala", "Jurek", "Maciek");

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter outWriter = new StringWriter();
			StreamResult streamResult = new StreamResult(outWriter);
			transformer.transform(source, streamResult);
			StringBuffer sb = outWriter.getBuffer();

			return sb.toString();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

		return "";
	}

	private Document addPayers(Document document, Element element, String... payers) {
		Element payersElement = document.createElement("PAYERS");
		element.appendChild(payersElement);

		for(String payer : payers) {
			Element payerItem = document.createElement("PAYER");
			payerItem.appendChild(document.createTextNode(payer));
			payersElement.appendChild(payerItem);
		}

		return document;
	}

}
