
package com.bing.algorithms4.util;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

public class FileUtil {

	private static final String DEFAULT_ENCODING = "GBK";
	private static final int DEFAULT_BUFFERED_SIZE = 1024;

	/**
	 * 从文件中读取内容，以String的形式返回
	 * 
	 * @param fileName
	 *            文件名
	 * @param ignoreLines
	 *            忽略的行数
	 */
	public static String readFile(String fileName, int ignoreLines, String encoding)
			throws FileNotFoundException, IOException {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName can not be null");
		}
		if(StringUtil.isEmpty(encoding)){
			encoding = DEFAULT_ENCODING;
		}
		StringBuffer text = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encoding),DEFAULT_BUFFERED_SIZE);

			for (int i = 0; i < ignoreLines; i++) {
				reader.readLine();
			}

			String line = null;
			while ((line = reader.readLine()) != null) {
				text.append(line).append("\n");
			}
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return text.toString();
	}

    public static String readFile(InputStream inputStream)
            throws FileNotFoundException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream can not be null");
        }
        StringBuffer text = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream),DEFAULT_BUFFERED_SIZE);
            String line = null;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }

    public static String readFile(String fileName)
            throws FileNotFoundException, IOException {
        return readFile(fileName,0,"utf-8");
    }
	/**
	 * 读取文件内容，以字符串数组形式返回
	 * @param fileName
	 * @param startLine
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String[] readFileToArry(String fileName, int startLine, String encoding)
			throws FileNotFoundException, IOException {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName can not be null");
		}
		if(StringUtil.isEmpty(encoding)){
			encoding = DEFAULT_ENCODING;
		}
		List<String> lineList = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader =  new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encoding),DEFAULT_BUFFERED_SIZE);

			for (int i = 0; i < startLine; i++) {
				reader.readLine();
			}
			String line = null;
			while ((line = reader.readLine()) != null) {
				lineList.add(line);
			}
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lineList.toArray(new String[0]);
	}
	/**
	 * 读取文件内容，以字节数组形式返回
	 * @param fileName
	 *            文件名
	 * @param ignoreLines
	 *            忽略行数
	 * @return 文件字节
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static byte[] readDataFile(String fileName, int ignoreLines)
			throws FileNotFoundException, IOException {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName can not be null");
		}

		RandomAccessFile in = null;
		byte[] buffer = null;
		try {
			in = new RandomAccessFile(fileName, "r");

			for (int i = 0; i < ignoreLines; i++) {
				in.readLine();
			}

			buffer = new byte[(int) in.length()];
			in.read(buffer);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer;
	}
	/**
	 * 读取文件内容某一行的数据
	 * @param fileName
	 * @param line
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readLine(String fileName, int line, String encoding)
			throws FileNotFoundException, IOException {
		if (fileName == null) {
			throw new IllegalArgumentException("fileName can not be null");
		}
		if(StringUtil.isEmpty(encoding)){
			encoding = DEFAULT_ENCODING;
		}
		BufferedReader reader = null;
		try {
			reader =  new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encoding),DEFAULT_BUFFERED_SIZE);

			for (int i = 1; i < line; i++) {
				reader.readLine();
			}

			return reader.readLine();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void move(String srcFile, String desFile) {
		File inputFile = new File(srcFile);
		File outputFile = new File(desFile);
		try {
			inputFile.renameTo(outputFile);
		} catch (Exception ex) {
			throw new RuntimeException("Can not mv" + srcFile + " to "
					+ desFile + ex.getMessage());
		}
	}

	public static boolean copy(String src, String dest) throws IOException {
		FileChannel in = null;
		FileChannel out = null;
		try {
			if (!new File(src).exists()) {
				return false;
			}
			in = new FileInputStream(src).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
			return true;
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static void makehome(String home) throws Exception {
		File homedir = new File(home);
		if (!homedir.exists())
			try {
				homedir.mkdirs();
			} catch (Exception ex) {
				throw new Exception("Can not mkdir :" + home
						+ " Maybe include special charactor!");
			}
	}

	public static void copyDir(String sourcedir, String destdir)
			throws Exception {
		File dest = new File(destdir);
		File source = new File(sourcedir);
		String files[] = source.list();
		try {
			makehome(destdir);
		} catch (Exception ex) {
			throw new Exception("CopyDir:" + ex.getMessage());
		}
		for (int i = 0; i < files.length; i++) {
			String sourcefile = source + File.separator + files[i];
			String destfile = dest + File.separator + files[i];
			File temp = new File(sourcefile);
			if (temp.isFile())
				try {
					copy(sourcefile, destfile);
				} catch (Exception ex) {
					throw new Exception("CopyDir:" + ex.getMessage());
				}
		}

	}

	public static void recursiveRemoveDir(File directory) throws Exception {
		if (!directory.exists())
			throw new IOException(directory.toString() + " do not exist!");
		String filelist[] = directory.list();
		File tmpFile = null;
		for (int i = 0; i < filelist.length; i++) {
			tmpFile = new File(directory.getAbsolutePath(), filelist[i]);
			if (tmpFile.isDirectory())
				recursiveRemoveDir(tmpFile);
			else if (tmpFile.isFile())
				try {
					tmpFile.delete();
				} catch (Exception ex) {
					throw new Exception(tmpFile.toString()
							+ " can not be deleted " + ex.getMessage());
				}
		}

		try {
			directory.delete();
		} catch (Exception ex) {
			throw new Exception(directory.toString() + " can not be deleted "
					+ ex.getMessage());
		} finally {
			filelist = null;
		}
	}

	public static void writeToFile(String filedir, String fileName, byte[] data, String encoding) {
		DataOutputStream dout = null;
		try {
			makehome(filedir);
			if(StringUtil.isEmpty(encoding)){
				encoding = DEFAULT_ENCODING;
			}
			FileOutputStream fout = new FileOutputStream(filedir + fileName);
		    dout = new DataOutputStream(fout);
		    dout.write(data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			try {
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	

	/*追加方式写入文件*/
	public static void writeToFile(String filedir, String fileName, String data, String encoding) {
		OutputStreamWriter fw =null;
		try {
			makehome(filedir);
			if(StringUtil.isEmpty(encoding)){
				encoding = DEFAULT_ENCODING;
			}
			 fw = new OutputStreamWriter(
					new FileOutputStream((filedir + fileName),true), encoding);
			fw.write(data);
			fw.flush();
		} catch (Exception ex) {
            ex.printStackTrace();
		}finally{
			if(fw !=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void writeToFile(String filedir, String fileName, String data) {
		writeToFile(filedir,fileName,data,DEFAULT_ENCODING);
	}

	public static String getExtName(File file) {
		return getExtName(file.getName());
	}

	public static String getExtName(String fileName) {
		if (fileName == null)
			return "";
		int index = fileName.lastIndexOf(".");
		return (index == -1) ? "" : fileName.substring(index);
	}

	public static String getNameWithTimestamp(String fileName) {
		return "f" + System.currentTimeMillis() + "_" + fileName;
	}


	/**
	 * 强制删除文件夹(不为空的情况下)
	 * 
	 * @param dir
	 *            文件夹
	 */
	public static void forceDeleteDir(File dir) {
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					file.delete();
				} else if (file.isDirectory()) {
					forceDeleteDir(file);
				}
			}
			dir.delete();
		}
	}

	private static final String illgalFileName = "[\\\\/:*?\"<>|]";

	private static final String illgalExcelSheetName = "[\\\\/:*?\\[\\]]";

	/**
	 * 修正文件名(去掉windows平台下的非法字符)
	 * 
	 * @param fileName
	 *            原始文件名
	 * @return 修正后的文件名
	 */
	public static String correctFileName(String fileName) {
		if (fileName == null)
			return "file";
		String ret = fileName.replaceAll(illgalFileName, "");
		return ret;
	}

	/**
	 * 修正excel文件sheet名
	 * 
	 * @param sheetName
	 *            原始sheet名
	 * @return 修正后的合法sheet名
	 */
	public static String correctExcelSheetName(String sheetName) {
		if (sheetName == null)
			return "sheet";
		String name = sheetName.replaceAll(illgalExcelSheetName, "");
		if (name.length() > 31) {
			name = name.substring(0, 31);
		}
		return name;
	}

	private static Random rnd = new Random();

	public final static String ENCODING="GBK";
	
	
	/**
	 * Linux 用命令打包目录,并等待命令执行完毕
	 * @param dirPath 被打包目录的绝对路径
	 * @param newFileName 压缩打包后的文件名
	 * @return 结果：打包后的文件放在被打包目录下，同时删除xls.txt文件。
	 */
	public static long linuxTar(String dirPath, String newFileName){
		StringBuilder sb = new StringBuilder(" cd ").append(dirPath)
		.append("; tar -zcvf ")
		.append(newFileName).append(".tar.gz  *.*;");
		sb.append("rm -rf *.xls;rm -rf *.txt;rm -rf *.xml");
		String[] comms = new String[]{"/bin/sh","-c",sb.toString()};
		Runtime rt= Runtime.getRuntime();
		try {
			Process process = rt.exec(comms);
			int value = process.waitFor();
			if(value == 0){
			} else {
			}
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
		File f=new File(dirPath+"/"+newFileName+".tar.gz");
		return f.length();
	}
	/**
	 * 删除目录以及下面的文件
	 * 包含目录下有目录的情况
	 * @param filepath
	 */
	public static void delFiles(String filepath){
		if(filepath==null||"".equals(filepath))
			return;
		File dir = new File(filepath);
		if(!dir.exists())
			return;
		if(dir.isDirectory()){
			File[] subFile = dir.listFiles();
			for(int i = 0;i<subFile.length;i++){
				delFiles(subFile[i].getAbsolutePath());					
			}
		}		
		dir.delete();
	}
	/**
	 * 获取目录下的文件
	 * @param filepath
	 * @return
	 */
	public static Map<String,String> getFiles(String filepath){
		Map<String,String> map=new HashMap<String,String>();
		if(filepath==null||"".equals(filepath))
			return map;
		File dir = new File(filepath);
		if(!dir.exists()||!dir.isDirectory())
			return map;
		File[] subFile = dir.listFiles();
		String fileName;
		String path;
		for(int i = 0;i<subFile.length;i++){
			fileName=subFile[i].getName();
			path="/"+dir.getName()+"/"+fileName;
			map.put(fileName, path);
		}
		return map;
	}

}
