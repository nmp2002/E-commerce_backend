package com.ttisv.springbootwildfly.common;

import com.ttisv.common.network.http.CallAPI;

public class Constants {

	public static final String URL_API_FULL_VIN = CallAPI.API_TMS+"/api/services/app/ApiInsurance/GetFullVinNumber";
	public static final String URL_API_CUSTOMER_INFO = CallAPI.API_TMS+"/api/services/app/ApiInsurance/GetCustomerInfo";
	public static final String URL_API_CLAIMNOTIFICATION = CallAPI.API_TMS+"/api/services/app/ApiInsurance/ClaimNotification";

	public static class API_RESPONSE_CODE {
		public static final String UNAUTHORIZED = "401";
	}

	public static class STATUS {
		public static final Long DEFAULT = -1L;
		public static final String ACTIVE = "1";
		public static final String INACTIVE = "0";
		public static final String DELETE = "2";
		public static final String UNLOCK = "4";
		public static final String LOCK = "5";
	}

	public static class BANK_ACTIVE {
		public static final String ACTIVE = "Y";
		public static final String INACTIVE = "N";
	}

	public static class OBJECT_TYPE {
		public static Long GROUP_ROLE = 1L;
		public static Long ROLE = 2L;
	}
}
