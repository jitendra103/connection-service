package com.kr.connected.model;

/*
 * This is class will work as graph edge
 */
public class CityEdge {

	private String originCity;
	private String destCity;
	public CityEdge(String originCity, String destCity) {
		super();
		this.originCity = originCity;
		this.destCity = destCity;
	}
	public String getOriginCity() {
		return originCity;
	}
	public void setOriginCity(String fromCity) {
		this.originCity = fromCity;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String toCity) {
		this.destCity = toCity;
	}
	@Override
	public String toString() {
		return "CityEdge [originCity=" + originCity + ", destCity=" + destCity + "]";
	}
	
}
