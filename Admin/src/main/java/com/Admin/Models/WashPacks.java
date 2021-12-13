package com.Admin.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WashPackages")
public class WashPacks {
	
	@Id
	int id;
	String packName;
	int cost;
	String description;
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return packName;
	}
	public void setName(String name) {
		this.packName = name;
	}
	@Override
	public String toString() {
		return "WashPacks [id=" + id + ", name=" + packName + ", cost=" + cost + ", description=" + description + "]";
	}
	
	
	
}