package com.xuzc.hadoop.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class HdfsUtil {
	public static FileSystem getFileSystem(){
		FileSystem hdfs=null;
		try {
			Configuration conf = new Configuration();
			hdfs = FileSystem.get(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hdfs;
	}
}
