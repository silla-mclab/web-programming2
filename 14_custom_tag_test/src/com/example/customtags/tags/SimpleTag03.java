package com.example.customtags.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag03 extends SimpleTagSupport {
	private String color;

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<div style='color:" + color + ";'>");
		getJspBody().invoke(null);
		out.print("</div>");
	}
	
}
