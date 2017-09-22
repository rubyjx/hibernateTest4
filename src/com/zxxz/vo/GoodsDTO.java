package com.zxxz.vo;

import java.util.HashSet;
import java.util.Set;

public class GoodsDTO {
	private Integer goodsID;
	// 商品名称
	private String goodsName;
	// 商品价格
	private double goodsPrice;
	// 商品对应的订单集合
	private Set<Order1DTO> orderlist = new HashSet<Order1DTO>();

	public Set<Order1DTO> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(Set<Order1DTO> orderlist) {
		this.orderlist = orderlist;
	}

	public Integer getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public GoodsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GoodsDTO [goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + "]";
	}
	

}
