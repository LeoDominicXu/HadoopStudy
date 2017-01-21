package com.xuzc.hadoop.hdfs;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class HDFSUrlTest {
	static{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	@Test
	public void test(){
		InputStream is = null;
		String url = "hdfs://192.168.153.168:9000/output/part-r-00000";
		try {
			is = new URL(url).openStream();
			IOUtils.copyBytes(is, System.out, 4096, false);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(is);
		}
	}
}
