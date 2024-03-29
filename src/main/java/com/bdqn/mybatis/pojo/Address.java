package com.bdqn.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: Address
 * @Description:超市订单管理系统地址类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class Address implements Serializable {
	private static final long serialVersionUID = -3172620338923712916L;
	private Integer id;				//主键ID
	private String postCode; 	//邮编
	private String contact;		//联系人
	private String addressDesc;	//地址
	private String tel;			//联系电话
	private Integer createdBy; 		//创建者
	private Date creationDate; 	//创建时间
	private Integer modifyBy; 		//更新者
	private Date modifyDate;	//更新时间
	private Integer userId;			//用户ID
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
		return "Address{" +
				"id=" + id +
				", postCode='" + postCode + '\'' +
				", contact='" + contact + '\'' +
				", addressDesc='" + addressDesc + '\'' +
				", tel='" + tel + '\'' +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				", userId=" + userId +
				'}';
	}
}