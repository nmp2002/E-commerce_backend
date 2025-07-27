package com.ttisv.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class FileUtils {
	public static String readFileAsString(String string) throws IOException {
		InputStream inputStream = null;
		try {
			string = IOUtils.toString(inputStream = new FileInputStream(string), "UTF-8");
			inputStream.close();
		} catch (Exception ex) {
			if (inputStream != null) {
				inputStream.close();
			}
			throw ex;
		}
		return string;
	}

	public static byte[] loadFileToByteArray(final String name) throws IOException {
		InputStream inputStream = null;
		byte[] byteArray;
		try {
			byteArray = IOUtils.toByteArray(inputStream = new FileInputStream(name));
			inputStream.close();
		} catch (Exception ex) {
			if (inputStream != null) {
				inputStream.close();
			}
			throw ex;
		}
		return byteArray;
	}

	public static byte[] converInputStreamToByteArray(final InputStream inputStream) throws IOException {
		byte[] byteArray;
		try {
			byteArray = IOUtils.toByteArray(inputStream);
			inputStream.close();
		} catch (Exception ex) {
			if (inputStream != null) {
				inputStream.close();
			}
			throw ex;
		}
		return byteArray;
	}

	public static String loadFileToBase64String(final String s) throws Exception {
		try {
			return Base64.encodeBase64String(loadFileToByteArray(s));
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static boolean saveFile(final byte[] b, final String name) throws IOException {
		OutputStream outputStream = null;
		try {
			(outputStream = new FileOutputStream(name)).write(b);
			outputStream.close();
		} catch (Exception ex) {
			if (outputStream != null) {
				outputStream.close();
			}
			throw ex;
		}
		return true;
	}

	public static boolean saveFile(final byte[] b, final String parent, final String child) throws IOException {
		OutputStream outputStream = null;
		try {
			(outputStream = new FileOutputStream(new File(parent, child))).write(b);
			outputStream.close();
		} catch (Exception ex) {
			if (outputStream != null) {
				outputStream.close();
			}
			throw ex;
		}
		return true;
	}

	public static boolean saveFile(final String s, final String s2) throws Exception {
		try {
			return saveFile(Base64.decodeBase64(s), s2);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static File[] getListFileInDirectory(final String pathname, final String s) {
		File[] listFiles;
		try {
			listFiles = new File(pathname).listFiles(new CustomFilenameFilter(s));
		} catch (Exception ex) {
			throw ex;
		}
		return listFiles;
	}

	public static boolean moveFile(final File file, final String pathname) {
		try {
			if (file.renameTo(new File(pathname))) {
				file.delete();
				System.out.println(String.format("File moved successfully: file name [%1$s] to destination [%2$s]",
						file.getName(), pathname));
				return true;
			}
			System.out.println(String.format("Failed to move the file: file name [%1$s] to destination [%2$s]",
					file.getName(), pathname));
			return false;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static boolean copyFile(final File file, final String pathname) {
		try {
			if (file.renameTo(new File(pathname))) {
				System.out.println(String.format("File copy successfully: file name [%1$s] to destination [%2$s]",
						file.getName(), pathname));
				return true;
			}
			System.out.println(String.format("Failed to copy the file: file name [%1$s] to destination [%2$s]",
					file.getName(), pathname));
			return false;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
