package com.czecht.architecture.xml;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlServiceTest {

	private XmlService xmlService = new XmlService();

	@Test
	public void shouldCreateXml() {
		// given
		String expected = "xxxxx";

		CommercialArrangement customer = CommercialArrangement.builder().id(1l).name("dupa").build();

		// when
		String result = xmlService.convertToXML();

		// then
		System.out.println(result);
		assertThat(result).isNotEmpty();
	}
}
