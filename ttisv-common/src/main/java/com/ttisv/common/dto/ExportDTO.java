package com.ttisv.common.dto;

import java.io.ByteArrayOutputStream;

public class ExportDTO {
	private ByteArrayOutputStream stream;
	private String filename;
	public ByteArrayOutputStream getStream() {
		return stream;
	}
	public void setStream(ByteArrayOutputStream stream) {
		this.stream = stream;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
