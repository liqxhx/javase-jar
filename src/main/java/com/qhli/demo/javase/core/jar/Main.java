package com.qhli.demo.javase.core.jar;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("config","config.xml");
		String str = FileUtils.readFileToString(file, "utf-8") ;
		System.out.println(str);
	}
}
