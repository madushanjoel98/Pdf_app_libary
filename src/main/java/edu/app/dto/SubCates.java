package edu.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.app.domains.Category;
import edu.app.domains.Subcategory;

public class SubCates {
	@JsonProperty("data")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Subcategory> data;

	public List<Subcategory> getData() {
		return data;
	}

	public void setData(List<Subcategory> data) {
		this.data = data;
	}

	public SubCates(List<Subcategory> data) {
		super();
		this.data = data;
	}
	
	
}
