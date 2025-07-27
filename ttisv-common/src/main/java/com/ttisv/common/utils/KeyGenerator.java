package com.ttisv.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KeyGenerator {
	public static KeyGenerator singleton = new KeyGenerator();
	private final int SUB_SEQUENCE_SIZE = "0".length();
	private long preTimestampLong = 0L;
	private long subSequence = 0L;

	public String getKey() {
		String result = null;
		for (int i = 0; i < 10; i++) {
			try {
				result = populateTimestampKey();
			} finally {
				if (result != null) {
					break;
				}
				try {
					Thread.sleep(5L);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		return result;
	}

	private String populateTimestampKey() {
		StringBuffer resultBuf = new StringBuffer();

		Long timestampKey = getTimestampLong20();
		long curTimestampLong = timestampKey.longValue();
		synchronized (KeyGenerator.class) {
			setPreTimestampLong(curTimestampLong);

			long subSeq = getSubSequence();
			subSeq += 1L;
			setSubSequence(subSeq);

			resultBuf.append(curTimestampLong).append(populateSubSequence(subSeq));
		}
		return resultBuf.toString();
	}

	private String populateSubSequence(long subSeq) {
		String seqStr = "000" + Long.toString(this.subSequence);
		seqStr = seqStr.substring(seqStr.length() - this.SUB_SEQUENCE_SIZE);

		return seqStr;
	}

	private Long getTimestampLong20() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(timestamp);
		long result = Long.parseLong(datetimeFormat.format(calendar.getTime()));
		return new Long(result);
	}

	public long getPreTimestampLong() {
		return preTimestampLong;
	}

	public void setPreTimestampLong(long preTimestampLong) {
		this.preTimestampLong = preTimestampLong;
	}

	public long getSubSequence() {
		return subSequence;
	}

	private synchronized void setSubSequence(long subSequence) {
		if ((subSequence < 0L) || (subSequence >= 999L)) {
			this.subSequence = 0L;
		} else {
			this.subSequence = subSequence;
		}
	}

	public static String genSeq(String seq, int num) {
		int length = seq.length();
		String seqvalue = "";
		if (length < num) {
			for (int i = 0; i < num - length; i++)
				seqvalue = seqvalue + "0";
		}

		seqvalue = seqvalue + seq;
		return seqvalue;
	}
	

	public static  String genBaogiaBS(String data) {

		String[] dataArray = data.split("/");
		String baogiabs = data;
		if (dataArray.length > 1) {
			baogiabs = dataArray[0] + "/" + (NumberUtils.getInteger(dataArray[1]) + 1);
		} else
			baogiabs = dataArray[0] + "/1";
		return baogiabs;
	}
}
