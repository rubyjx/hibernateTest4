package com.zxxz.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order1DTO {
	private Integer orderID;
	// �µ���
	private String orderName;
	// �µ�ʱ��
	private Date orderTime;
	//�����µ���Ʒ
	private Set<GoodsDTO> goodslist=new HashSet<GoodsDTO>();
   
	public Set<GoodsDTO> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(Set<GoodsDTO> goodslist) {
		this.goodslist = goodslist;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Order1DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
