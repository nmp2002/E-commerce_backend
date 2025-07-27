package com.ttisv.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPUtils {
	private Session a;
	private String b;
	private int c;
	private String d;
	private String e;
	private String f;

	public Session getSessionSftp() {
		return this.a;
	}

	public void setSessionSftp(final Session a) {
		this.a = a;
	}

	public String getStrSftpHostIP() {
		return this.b;
	}

	public void setStrSftpHostIP(final String b) {
		this.b = b;
	}

	public int getiPortSftp() {
		return this.c;
	}

	public void setiPortSftp(final int c) {
		this.c = c;
	}

	public String getStrSftpUserName() {
		return this.d;
	}

	public void setStrSftpUserName(final String d) {
		this.d = d;
	}

	public String getStrSftpUserPass() {
		return this.e;
	}

	public void setStrSftpUserPass(final String e) {
		this.e = e;
	}

	public String getStrWorkingDirectory() {
		return this.f;
	}

	public void setStrWorkingDirectory(final String f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "SFtpUtils{sessionSftp=" + this.a + ", strSftpHostIP=" + this.b + ", iPortSftp=" + this.c
				+ ", strSftpUserName=" + this.d + ", strSftpUserPass=" + this.e + ", strWorkingDirectory=" + this.f
				+ '}';
	}

	public SFTPUtils(final String b, final String d, final String e, final int c) throws Exception {
		this.b = "";
		this.c = c;
		this.d = "";
		this.e = "";
		this.f = "";
		try {
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.a = getSftpSession(b, c, d, e);
			System.out.println("initial session: " + this.toString());
		} catch (Exception ex) {
			throw ex;
		}
	}

	public SFTPUtils(final String b, final String d, final String e) throws Exception {
		this.b = "";
		this.c = 22;
		this.d = "";
		this.e = "";
		this.f = "";
		try {
			this.b = b;
			this.c = 22;
			this.d = d;
			this.e = e;
			this.a = getSftpSession(b, this.c, d, e);
			System.out.println("initial session: " + this.toString());
		} catch (Exception ex) {
			throw ex;
		}
	}

	public boolean dispose() {
		boolean b = true;
		try {
			if (this.a != null && this.a.isConnected()) {
				this.a.disconnect();
				System.out.println("session disconnected.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			b = false;
		}
		return b;
	}

	public boolean putSftpFiles(File[] array, final String s, final boolean b, String str) throws Exception {
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			if (array == null || array.length <= 0) {
				System.out.println("no data file exists");
				return false;
			}
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s)) {
				channelSftp.cd(s);
			}
			if (b && !str.endsWith("\\") && !str.endsWith("/")) {
				if (str.contains("\\")) {
					str += "\\";
				} else {
					str += "/";
				}
			}
			for (int length = (array).length, i = 0; i < length; ++i) {
				final File file = array[i];
				channelSftp.put((InputStream) new FileInputStream(file), file.getName());
				System.out.println("File transfered successfully: " + file.getName());
				if (b) {
					FileUtils.moveFile(file, str + file.getName());
				}
			}
		} catch (JSchException ex2) {
		} catch (FileNotFoundException ex3) {
		} catch (SftpException ex) {
			final Throwable t = (Throwable) ex;
			((Throwable) ex).printStackTrace();
			throw new Exception(t.getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return true;
	}

	public boolean renameSftpFile(final String str, final String str2, final String s) throws Exception {
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s)) {
				channelSftp.cd(s);
			}
			System.out.println("Begin rename file " + str + " to file " + str2);
			channelSftp.rename(str, str2);
			System.out.println("End rename file " + str + " to file " + str2);
		} catch (JSchException ex2) {
		} catch (SftpException ex) {
			System.out.println(
					"Error rename file " + str + " to file " + str2 + ": error " + ((Throwable) ex).getMessage());
			((Exception) ex).printStackTrace();
			throw new Exception(((Throwable) ex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return true;
	}

	public boolean deleteSftpFiles(final String str, final boolean b) throws Exception {
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			System.out.println("Begin delete file: " + str);
			if (b) {
				channelSftp.rmdir(str);
			} else {
				channelSftp.rm(str);
			}
			System.out.println("End delete file: " + str);
		} catch (JSchException ex2) {
		} catch (SftpException ex) {
			System.out.println("Error delete file: " + str + "; Error=" + ((Throwable) ex).getMessage());
			((Exception) ex).printStackTrace();
			throw new Exception(((Throwable) ex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return true;
	}

	public boolean getSftpFile(final String str, final String s, final String str2) throws Exception {
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s)) {
				channelSftp.cd(s);
			}
			System.out.println("Begin get file: " + str + "write to Local file: " + str2);
			channelSftp.get(str, str2);
			System.out.println("End get file: " + str + "write to Local file: " + str2);
		} catch (JSchException ex2) {
		} catch (SftpException ex) {
			System.out.println("Error get file: " + str + "write to Local file: " + str2 + "; Error="
					+ ((Throwable) ex).getMessage());
			((Exception) ex).printStackTrace();
			throw new Exception(((Throwable) ex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return true;
	}

	public boolean getSftpFile(final String str, final String s, final OutputStream outputStream) throws Exception {
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s)) {
				channelSftp.cd(s);
			}
			System.out.println("Begin get file: " + str);
			channelSftp.get(str, outputStream);
			System.out.println("End get file: " + str);
		} catch (JSchException ex2) {
		} catch (SftpException ex) {
			System.out.println("Error get file: " + str + "; Error=" + ((Throwable) ex).getMessage());
			((Exception) ex).printStackTrace();
			throw new Exception(((Throwable) ex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection<ChannelSftp.LsEntry> listSftpFiles(String pwd) throws Exception {
		new Vector();
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		Vector ls = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(pwd)) {
				channelSftp.cd(pwd);
			}
			pwd = channelSftp.pwd();
			System.out.println("Begin list file: " + pwd);
			ls = channelSftp.ls(pwd);
			System.out.println("End list file: " + pwd);
		} catch (JSchException ex) {
		} catch (SftpException lsex) {
			System.out.println("Error list file " + pwd + "; Error=" + ((Throwable) lsex).getMessage());
			((Throwable) lsex).printStackTrace();
			throw new Exception(((Throwable) lsex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return (Collection<ChannelSftp.LsEntry>) ls;
	}

	@SuppressWarnings("rawtypes")
	public List getlistSftpFiles(String pwd) throws Exception {
		final ArrayList<String> list = new ArrayList<String>();
		Object openChannel = null;
		ChannelSftp channelSftp = null;
		try {
			openChannel = this.a.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			((Channel) openChannel).connect();
			System.out.println("Connected with sftp Channel.");
			channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(pwd)) {
				channelSftp.cd(pwd);
			}
			pwd = channelSftp.pwd();
			System.out.println("Begin list file: " + pwd);
			@SuppressWarnings("unchecked")
			Vector<LsEntry> vector = channelSftp.ls(pwd);
			for (final ChannelSftp.LsEntry lsEntry : vector) {
				list.add(lsEntry.getFilename());
				System.out.println("WorkingDirectory: " + pwd + "; file: " + lsEntry.getFilename());
			}
			System.out.println("End list file: " + pwd);
		} catch (JSchException ex2) {
		} catch (SftpException ex) {
			System.out.println("Error list file " + pwd + "; Error=" + ((Throwable) ex).getMessage());
			((Exception) ex).printStackTrace();
			throw new Exception(((Throwable) ex).getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
				channelSftp.exit();
				System.out.println("sftp channel disconnected.");
			}
			if (openChannel != null && ((Channel) openChannel).isConnected()) {
				((Channel) openChannel).disconnect();
				System.out.println("channel disconnected.");
			}
		}
		return list;
	}

	public boolean putSftpFiles(final File[] array, final String s) throws Exception {
		return this.putSftpFiles(array, s, false, "");
	}

	public boolean putSftpFiles(final File file, final String s, final boolean b, final String s2) throws Exception {
		return this.putSftpFiles(new File[] { file }, s, b, s2);
	}

	public boolean putSftpFiles(final File file, final String s) throws Exception {
		return this.putSftpFiles(file, s, false, "");
	}

	public static Session getSftpSession(final String s, final String s2, final String password) throws Exception {
		final JSch sch = new JSch();
		Session session;
		try {
			session = sch.getSession(s2, s);
			System.out.println("Session Host: " + session.getHost());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			final Properties config;
			(config = new Properties()).put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("Connecting to a session Host Server...");
			session.connect();
			System.out.println("session is established with host server.");
		} catch (Exception ex2) {
			final Exception ex = ex2;
			ex2.printStackTrace();
			throw ex;
		}
		return session;
	}

	public static Session getSftpSession(final String s, final int n, final String s2, final String password)
			throws Exception {
		final JSch sch = new JSch();
		Session session;
		try {
			session = sch.getSession(s2, s, n);
			System.out.println("Session Host: " + session.getHost());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.setTimeout(50000);
			final Properties config;
			(config = new Properties()).put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("Connecting to a session Host Server...");
			session.connect();
			System.out.println("session is established with host server.");
		} catch (Exception ex2) {
			final Exception ex = ex2;
			ex2.printStackTrace();
			throw ex;
		}
		return session;
	}

	@SuppressWarnings("null")
	public static boolean putSftpFiles(final String s, final String s2, final String password, File[] array,
			final String s3) throws Exception {
		final JSch sch = new JSch();
		try {
			final Session session = sch.getSession(s2, s);
			System.out.println("Session Host: " + session.getHost());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			final Properties config;
			(config = new Properties()).put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("Connecting to a session Host Server...");
			session.connect();
			System.out.println("session is established with host server.");
			final Channel openChannel = session.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			openChannel.connect();
			System.out.println("Connected with sftp Channel.");
			final ChannelSftp channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s3)) {
				channelSftp.cd(s3);
			}
			for (int length = (array).length, i = 0; i < length; ++i) {
				final File file = array[i];
				channelSftp.put((InputStream) new FileInputStream(file), file.getName());
				System.out.println("File transfered successfully: " + file.getName());
			}
			channelSftp.exit();
			System.out.println("sftp channel disconnected.");
			openChannel.disconnect();
			System.out.println("channel disconnected.");
			session.disconnect();
			System.out.println("session disconnected.");
			return true;
		} catch (JSchException | FileNotFoundException | SftpException ex2) {
			final SftpException ex = null;
			final Throwable t = (Throwable) ex;
			System.out.println(t.getMessage());
			throw new Exception(t.getMessage());
		}
	}

	@SuppressWarnings("null")
	public static boolean putSftpFiles(final String s, final int n, final String s2, final String password,
			final File[] array, final String s3) throws Exception {
		final JSch sch = new JSch();
		try {
			final Session session = sch.getSession(s2, s, n);
			System.out.println("Session Host: " + session.getHost());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			final Properties config;
			(config = new Properties()).put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("Connecting to a session Host Server...");
			session.connect();
			System.out.println("session is established with host server.");
			final Channel openChannel = session.openChannel("sftp");
			System.out.println("Connecting to a sftp Channel...");
			openChannel.connect();
			System.out.println("Connected with sftp Channel.");
			final ChannelSftp channelSftp = (ChannelSftp) openChannel;
			if (!StringUtils.isNullOrEmpty(s3)) {
				channelSftp.cd(s3);
			}
			for (final File file : array) {
				channelSftp.put((InputStream) new FileInputStream(file), file.getName());
				System.out.println("File transfered successfully: " + file.getName());
			}
			channelSftp.exit();
			System.out.println("sftp channel disconnected.");
			openChannel.disconnect();
			System.out.println("channel disconnected.");
			session.disconnect();
			System.out.println("session disconnected.");
			return true;
		} catch (JSchException | FileNotFoundException | SftpException ex2) {
			final SftpException ex = null;
			final Throwable t = (Throwable) ex;
			System.out.println(t.getMessage());
			throw new Exception(t.getMessage());
		}
	}
}
