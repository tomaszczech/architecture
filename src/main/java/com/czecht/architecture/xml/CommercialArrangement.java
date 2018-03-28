package com.czecht.architecture.xml;

import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommercialArrangement {

	private long id;

	private String name;

	private DateTime currentDate = new DateTime();


}
