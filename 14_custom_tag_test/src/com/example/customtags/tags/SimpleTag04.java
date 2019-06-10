package com.example.customtags.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag04 extends SimpleTagSupport {
	private String var = null;
	private String[] items = null;
	
	public void setVar(String var) {
		this.var = var;
	}
	
	public void setItems(String[] items) {
		this.items = items;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (var != null && items != null & (items instanceof String[])) {
			for(String item : items) {
				getJspContext().setAttribute(var, item);
				getJspBody().invoke(null);
			}
		}
		else {
			throw new SkipPageException();
		}
	}
}
