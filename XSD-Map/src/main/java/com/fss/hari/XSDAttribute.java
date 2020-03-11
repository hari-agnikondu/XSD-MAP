/*******************************************************************************
* Copyright (c) 2019 Harikrishna Agnikondu. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*
* Contributors:
*          Harikrishna Agnikondu - initial implementation and ongoing maintenance
*          
*******************************************************************************/
package com.fss.hari;

import java.util.ArrayList;
import java.util.List;

/** Represents an "attribute" schema definition.
 * 
 * @author Harikrishna Agnikondu
 *
 */
public class XSDAttribute {

	private String name;
	private boolean required;
	private String type;
	private List<String> options = new ArrayList<>();
	private String defaultValue;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
  public String getDefaultValue() {
    return defaultValue;
  }

public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
	

}
