package com.ttisv.common.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPClient {
	private String host = "13.212.82.2";
	private int port = 2022;
	private Session session = null;

	public SFTPClient() {
	}

	private static SFTPClient instance;

	public static SFTPClient getInstance() {
		synchronized (SFTPClient.class) {
			if (instance == null) {
				instance = new SFTPClient();
			}
			return instance;
		}
	}

	public void connect() throws JSchException {
		JSch jsch = new JSch();

		// Uncomment the line below if the FTP server requires certificate
		// jsch.addIdentity("private-key-path);

		session = jsch.getSession("ftp01", host, port);

		// Comment the line above and uncomment the two lines below if the FTP server
		// requires password
		// session = jsch.getSession("username", host, port);
		session.setPassword("8Bd)QYm!");

		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
	}

	public void upload(String source, String destination) throws JSchException, SftpException {
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftpChannel = (ChannelSftp) channel;
		sftpChannel.put(source, destination);
		sftpChannel.exit();
	}

	public void download(String source, String destination) throws JSchException, SftpException {
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftpChannel = (ChannelSftp) channel;
		sftpChannel.get(source, destination);
		sftpChannel.exit();
	}

	public void disconnect() {
		if (session != null) {
			session.disconnect();
		}
	}

	public void uploadFiletest() {
		try {
			connect();
			upload("D:\\duan/grade.json", "NHAN/grade.json");
			disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean connect(String host, int port, String username, String password) throws JSchException {
		JSch jsch = new JSch();
		session = jsch.getSession(username, host, port);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		return session.isConnected();
	}

	public void upload(String destination, InputStream input) throws JSchException, SftpException {
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftpChannel = (ChannelSftp) channel;
		sftpChannel.put(input, destination);
		sftpChannel.exit();
	}

	public boolean pushFileBySFTP(String officecode, String officename, String username, String password,
			String clientIP, int clientPort, String workingRemoteDirectory, Map<String, String> mapData,
			String fileNameDetail) throws IOException {
		try {
			if (connect(clientIP, clientPort, username, password)) {
				if (mapData != null && !mapData.isEmpty()) {
					for (String officecodeData : mapData.keySet()) {
						boolean isContinue = (officecode == null || officecode.isEmpty()) ? true
								: (Objects.equals(officecode, officecodeData) ? true : false);
						if (isContinue) {
							String data = mapData.get(officecodeData);
							String filename = String.format(fileNameDetail, officecodeData, "G",
									DateTimeUtils.getSysDateTime(DateTimeUtils.PATTERN.DDMMYYYY.getValue()),
									DateTimeUtils.getSysDateTime(DateTimeUtils.PATTERN.HHmmss.getValue())) + ".csv";
							System.out.println("Thực hiện đẩy file SFTP:" + data);
							System.out.println("Thực hiện đẩy file SFTP:" + filename);
							InputStream input = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
							upload(workingRemoteDirectory + "/" + filename, input);
							input.close();
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
