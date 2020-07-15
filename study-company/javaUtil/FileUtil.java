package com.classroom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	   /**
     * 复制文件,文件存在且复制成功时,返回true,文件不存在或者复制失败返回false
     *
     * @param oldPath 原路径
     * @param newPath 新路径
	 * @throws IOException 
     */
    public static boolean copyFile(String oldPath, String newPath) throws IOException {

        int byteRead;
        File oldFile = new File(oldPath);
        File newFile= new File(newPath);
        File dir = newFile.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
        if(!newFile.exists()) {
        	newFile.createNewFile();
        	
        }
        if (oldFile.exists()) { //文件存在时
            InputStream inStream = null;
            FileOutputStream fs = null;
            try {
                inStream = new FileInputStream(oldPath); //读入原文件
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteRead = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteRead);
                }
                inStream.close();
                fs.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }finally {
                try {
                    inStream.close();
                    fs.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        } else {
            return false;
        }

    }
}
