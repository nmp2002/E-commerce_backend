package com.ttisv.common.utils;

import com.ttisv.common.network.http.CallAPI;

public class TtisvConstant {

	private final static String API_SSA = CallAPI.API_TMS + "/api/services/app/ApiInsurance";
	public final static String VEHICLE_AGE = "VEHICLE_AGE";
	public final static String INSURANCE_COMPANY = "INSURANCE_COMPANY";
	public final static String BG = "BG";
	public final static String GCN = "GCN";
	public final static int BUFFER_SIZE = 1024;
	public final static int DEFAULT_VALUE = -1;
	public final static Long ZERO = 0L;
	public final static String DEFAULT_CCY = "VND";
	public final static String ALL = "ALL";
	public final static String YES = "Có";
	public final static String NO = "Không";
	public final static String START_JOB = "START_JOB";
	public final static String BAO_VIET = "01";

	public static enum OFFICE_TYPE {
		ALL("ALL", "Tất cả"), AGENT("G", "Đại lý"), OFFICE("B", "Công ty bảo hiểm"),
		OFFICE_BRANCH("Q", "Chi nhánh Công ty bảo hiểm");

		private String key;
		private String text;

		private OFFICE_TYPE(String key, String text) {
			this.key = key;
			this.text = text;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}
	}

	public static enum CUST_TYPE {
		PERSONAL("1", "Cá nhân", "C"), ENTERPRISE("2", "Doanh nghiệp", "T");

		private String key;
		private String text;
		private String code;

		private CUST_TYPE(String key, String text, String code) {
			this.key = key;
			this.text = text;
			this.code = code;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public class SYSTEM_PARA {
		public final static String CSV = "CSV";
		public final static String PDF = "PDF";
		public final static String SFTP = "SFTP";
		public final static String EXPORT = "EXPORT";
		public final static String PDF_DIR = "PDF_DIR";
		public final static String CSV_DIR = "CSV_DIR";
		public final static String FILE_NAME_DETAIL = "FILE_NAME_DETAIL";
		public final static String SFTP_IP = "SFTP_IP";
		public final static String SFTP_USER = "SFTP_USER";
		public final static String SFTP_PASS = "SFTP_PASS";
		public final static String SFTP_PORT = "SFTP_PORT";
		public final static String SFTP_WORKING_DIRECTORY = "SFTP_WORKING_DIRECTORY";
		public final static String SFTP_BACKUP_DIRECTORY = "SFTP_BACKUP_DIRECTORY";
		public final static String STR_DATE_SEARCH = "STR_DATE_SEARCH";
		public final static String BACKUP = "BACKUP";
	}

	public class SEQ_NAME {
		public final static String SEQ_TTI_QUOTA_POLICY_NO = "SEQ_TTI_QUOTA_POLICY_NO";
		public final static String SEQ_GEN_POLICY_NO = "SEQ_GEN_POLICY_NO";
		public final static String SEQ_GEN_QUOTA_NO = "SEQ_GEN_QUOTA_NO";
		public final static String SEQ_TTI_QUOTA_NO = "SEQ_TTI_QUOTA_NO";
	}

	public class URL_SSA_DTL {
		public final static String GET_CAR_INFO = API_SSA + "/GetCarInfo/?vinNoInput=";
		public final static String GET_INSURANCE_DATA = API_SSA + "/InsuranceData";
	}

	public class STATUS {
		public final static String INACTIVE = "0";
		public final static String ACTIVE = "1";
		public final static String DELETE = "2";
		public final static long FLG_TRUE = 1;
		public final static long FLG_FALSE = 0;
	}

	public class QUOTA_POLICY_STATUS {
		public final static String NEW = "0"; // Chưa chuyển bảo hiểm duyệt
		public final static String APPROVING = "1"; // Chờ bảo hiểm duyệt
		public final static String APPROVED = "2"; // Đã duyệt
		public final static String REJECT = "3"; // Đã Từ chối
		public final static String CONTRACTED = "4";// Đã chuyển thành Hợp đồng
		public final static String CANCEL = "5";// Đã hủy
		// Transer status
		public final static String NOT_SEND = "0";
		public final static String SEND_SUCCESS = "1";
		public final static String SEND_ERROR = "2";
	}

	public class QUOTA_STATUS {
		public final static String NEW = "0";// Chưa chuyển bảo hiểm duyệt
		public final static String APPROVING = "1";// Chờ bảo hiểm duyệt
		public final static String APPROVED = "2";// Đã duyệt
		public final static String REJECT = "3";// Đã Từ chối
		public final static String CONTRACTED = "4";// Đã chuyển thành Hợp đồng
		public final static String CANCEL = "5";// Đã hủy
		public final static String NOT_TRANSFER = "0";
		public final static String TRANSFERED = "1";
	}

	public class QUOTA_TYPE {
		public final static String GOC = "G";
		public final static String SDBS = "B";
		public final static String TAITUC = "TT";
	}

	public class CONTRACT_STATUS {
		public final static String NEW = "0";
		public final static String APPROVING = "1";
		public final static String APPROVED = "2";
		public final static String REJECT = "3";
		public final static String BACK = "4";
	}

	public class TBL_FEE {
		public final static String TTI_FEEMINIMUM = "1";
		public final static String TTI_INSURANCEFEE = "2";
		public final static String TTI_DISCOUNTFEE = "3";
		public final static String TTI_INSURANCERISK = "4";
		public final static String TTI_DEDUCTIBLEGCN = "5";
		public final static String TTI_LIMITGCN = "6";
	}

	public class TABLE_NAME {
		public final static String TTI_CARBRAND = "TTI_CARBRAND";
		public final static String TTI_COMPANY = "TTI_COMPANY";
		public final static String TTI_CARMODEL = "TTI_CARMODEL";
		public final static String TTI_PURPOSEOFUSE = "TTI_PURPOSEOFUSE";
		public final static String INSURANCE_TYPE = "INSURANCE_TYPE";
		public final static String TTI_BRANCH = "TTI_BRANCH";
		public final static String TTI_AGENT = "TTI_AGENT";
		public final static String TTI_CUSTOMERTYPE = "TTI_CUSTOMERTYPE";
		public final static String TTI_COUNTRY = "TTI_COUNTRY";
		public final static String TTI_DISTRICT = "TTI_DISTRICT";
		public final static String TTI_WARD = "TTI_WARD";
		public final static String TTI_PROVINCE = "TTI_PROVINCE";
		public final static String TTI_INSURANCECAMPAIGN = "TTI_INSURANCECAMPAIGN";
		public final static String TTI_DISCOUNTFEE = "TTI_DISCOUNTFEE";
		public final static String TTI_CARCLASS = "TTI_CARCLASS";
		public final static String TTI_CAREDITION = "TTI_CAREDITION";
		public final static String TTI_CONTRACTTYPE = "TTI_CONTRACTTYPE";
	}

	public static enum INCLUDE_VAT {
		INCLUDE("1", "Đã bao gồm thuế", "D"), NON_INCLUDE("2", "Không bao gồm thuế", "K");

		private String key;
		private String text;
		private String code;

		private INCLUDE_VAT(String key, String text, String code) {
			this.key = key;
			this.text = text;
			this.code = code;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public static enum INSURANCE_TYPE {
		VOLUNTARY("2", "Tự nguyện", "T"), COMPULSORY("1", "Bắt buộc", "B");

		private String key;
		private String text;
		private String code;

		private INSURANCE_TYPE(String key, String text, String code) {
			this.key = key;
			this.text = text;
			this.code = code;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public static enum DISCOUNTID {
		YES("C", "Có"), NO("K", "Không");

		private String key;
		private String text;

		private DISCOUNTID(String key, String text) {
			this.key = key;
			this.text = text;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}
	}

	public static enum ACCESSORY_TYPE {
		INSIDE("1", "Chính hãng"), OUTSIDE("2", "Không thuộc hãng");

		private String key;
		private String text;

		private ACCESSORY_TYPE(String key, String text) {
			this.key = key;
			this.text = text;
		}

		public String getKey() {
			return this.key;
		}

		public String getText() {
			return this.text;
		}
	}

	public class TEMPLATE_TYPE {
		public final static int TEMPLATE_01 = 1;
		public final static int TEMPLATE_02 = 2;
		public final static int TEMPLATE_03 = 3;
		public final static int TEMPLATE_04 = 4;
		public final static int TEMPLATE_05 = 5;
		public final static int TEMPLATE_06 = 6;
		public final static int TEMPLATE_07 = 7;
		public final static int TEMPLATE_08 = 8;
		public final static int TEMPLATE_09 = 9;
		public final static int TEMPLATE_10 = 10;
		public final static int TEMPLATE_11 = 11;
		public final static int TEMPLATE_12 = 12;
		public final static int TEMPLATE_13 = 13;
	}

}
