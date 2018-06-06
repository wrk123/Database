package com.app.excel;

public class BuildPojo {

	public Object createClass(StringBuilder columnHeader) {
		Object createClass = null;
		String[] headerValues = columnHeader.toString().split(",");
		int len = headerValues.length;
		for (int i = 0; i < len; i++) {
			System.out.println("---- Header values are ----" + headerValues[i]);
		}

		return createClass;

	}

}
