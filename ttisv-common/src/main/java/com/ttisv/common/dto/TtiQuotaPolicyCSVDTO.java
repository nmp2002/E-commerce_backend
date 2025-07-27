package com.ttisv.common.dto;

import java.util.List;

public class TtiQuotaPolicyCSVDTO {
	private List<String> policyDetail;
	private List<List<String>> policyInsurance;

	public List<String> getPolicyDetail() {
		return policyDetail;
	}

	public void setPolicyDetail(List<String> policyDetail) {
		this.policyDetail = policyDetail;
	}

	public List<List<String>> getPolicyInsurance() {
		return policyInsurance;
	}

	public void setPolicyInsurance(List<List<String>> policyInsurance) {
		this.policyInsurance = policyInsurance;
	}
}
