package com.assign.project.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private String id;
		
		@Column(name="prod_id")	
		private String prodId;
		
		@Column(name="prod_category")
		private String prodCategory;
		
		@Column(name="prod_brand")
		private String prodBrand;
		
		public Customer()
		{
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getProdId() {
			return prodId;
		}

		public void setProdId(String prodId) {
			this.prodId = prodId;
		}

		public String getProdCategory() {
			return prodCategory;
		}

		public void setProdCategory(String prodCategory) {
			this.prodCategory = prodCategory;
		}

		public String getProdBrand() {
			return prodBrand;
		}

		public void setProdBrand(String prodBrand) {
			this.prodBrand = prodBrand;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", prodId=" + prodId + ", prodCategory=" + prodCategory + ", prodBrand="
					+ prodBrand + ", getId()=" + getId() + ", getProdId()=" + getProdId() + ", getProdCategory()="
					+ getProdCategory() + ", getProdBrand()=" + getProdBrand() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

		
		
	}


