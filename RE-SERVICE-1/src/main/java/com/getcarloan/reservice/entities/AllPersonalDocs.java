package com.getcarloan.reservice.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllPersonalDocs {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docs_generator")
	@SequenceGenerator(name = "docs_generator", sequenceName = "DOCUMENTS_SEQUENCE", initialValue = 888, allocationSize = 0)
	private int docId;
	
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[] itr;
	@Lob
	private byte[] adharCard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] sign;
	@Lob
	private byte[] bankCheque;
	@Lob
	private byte[] salarySlips;
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public byte[] getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}
	public byte[] getPanCard() {
		return panCard;
	}
	public void setPanCard(byte[] panCard) {
		this.panCard = panCard;
	}
	public byte[] getItr() {
		return itr;
	}
	public void setItr(byte[] itr) {
		this.itr = itr;
	}
	public byte[] getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(byte[] adharCard) {
		this.adharCard = adharCard;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getSign() {
		return sign;
	}
	public void setSign(byte[] sign) {
		this.sign = sign;
	}
	public byte[] getBankCheque() {
		return bankCheque;
	}
	public void setBankCheque(byte[] bankCheque) {
		this.bankCheque = bankCheque;
	}
	public byte[] getSalarySlips() {
		return salarySlips;
	}
	public void setSalarySlips(byte[] salarySlips) {
		this.salarySlips = salarySlips;
	}
	
}
