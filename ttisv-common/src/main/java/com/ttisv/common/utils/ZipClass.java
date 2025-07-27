package com.ttisv.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ZipClass{
    private static final String _strEncode = "UTF8";

    public ZipClass(){
    }

    public String ZipToString(String strData) throws Exception{
        try{
            String zipData = "";
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzos = new GZIPOutputStream(baos);
            byte[] bData = strData.getBytes(_strEncode);
            gzos.write(bData, 0, bData.length);
            gzos.close();
            byte[] b = baos.toByteArray();
           Base64Utils.base64Encode(baos.toByteArray());
            baos.close();
            return zipData;
        } catch(Exception ex){
            throw ex;
        }
    }

    public String UnZipToString(String strZipped) throws Exception{
        try{
            GZIPInputStream gzis = new GZIPInputStream(new ByteArrayInputStream(Base64Utils.base64Decode(strZipped)));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while((len = gzis.read(buf)) > 0){
                baos.write(buf, 0, len);
            }
            gzis.close();
            baos.close();
            return new String(baos.toByteArray(), _strEncode);
        } catch(Exception ex){
            throw ex;
        }
    }
}