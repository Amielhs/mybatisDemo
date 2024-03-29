package com.bdqn.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Provider
 * @Description:超市订单管理系统供货商类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class Provider implements Serializable {

	private static final long serialVersionUID = 2527829396552576860L;
	private Integer id;   //id
	private String proCode; //供应商编码
	private String proName; //供应商名称
	private String proDesc; //供应商描述
	private String proContact; //供应商联系人
	private String proPhone; //供应商电话
	private String proAddress; //供应商地址
	private String proFax; //供应商传真
	private Integer createdBy; //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
	private Date modifyDate;//更新时间

	//collection
	private List<Bill> billList;//订单列表

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Provider{" +
				"id=" + id +
				", proCode='" + proCode + '\'' +
				", proName='" + proName + '\'' +
				", proDesc='" + proDesc + '\'' +
				", proContact='" + proContact + '\'' +
				", proPhone='" + proPhone + '\'' +
				", proAddress='" + proAddress + '\'' +
				", proFax='" + proFax + '\'' +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				'}';
	}
}
