package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "onedbp1")
public class ApiData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loadId;
	private long shipperId;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private int weight;
	private String comment;
	Date date = new Date();
	//private String date;

	public ApiData(int loadId , int shipperId, String loadingPoint, String unloadingPoint, String productType, String truckType,
			int noOfTrucks, int weight, String comment , Date date) {
		super();
		this.loadId = loadId;
		this.shipperId = shipperId;
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.comment = comment;
		this.date = date;
	}
	
	
	public long getLoadId() {
		return loadId;
	}


	public void setLoadId(long loadId) {
		this.loadId = loadId;
	}


	public long getShipperId() {
		return shipperId;
	}


	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}


	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public int getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(int noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ApiData() {
		super();
	}
	
	

}
