package com.xuzc.hadoop.hdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import com.xuzc.hadoop.util.HdfsUtil;

public class HdfsTest {
	public static void main(String[] args) throws IOException {
		FileSystem hdfs = HdfsUtil.getFileSystem();
		Path path = new Path("hdfs://192.168.153.168:9000/output/part-r-00000");
		FSDataInputStream input = hdfs.open(path);
		IOUtils.copyBytes(input, System.out, 4096, false);
		IOUtils.closeStream(input);
		
	
	}
	@Test
	public void test() throws FileNotFoundException, IOException{
		FileSystem hdfs = HdfsUtil.getFileSystem();
		Path path = new Path("hdfs://192.168.153.168:9000/");
		FileStatus[] status = hdfs.listStatus(path);
		for(FileStatus fs : status){
			Path p = fs.getPath();
			String info = fs.isDirectory()? "目录":"文件";
			System.out.println(info+":"+p);
		}
	}
}
