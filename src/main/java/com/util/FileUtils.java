package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

	public static void writeToFile(String text, String outputFile, boolean isAppend) {
		FileOutputStream fout;
		if (text != null) {
			try {
				File file = new File(outputFile);
				synchronized (file) {
					fout = new FileOutputStream(file, isAppend);
					fout.write(text.getBytes());
					fout.flush();
				}
			} catch (FileNotFoundException fe) {
				System.err.println("File not found.");
			} catch (IOException ioe) {
			} finally {
				fout = null;
			}
		}
	}

	public static void copyFile(File destinationFile, File ToFile) {
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		if(!ToFile.exists()) {
			try {
				ToFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
//			File infile =new File("C:\\MyInputFile.txt");
//			File outfile =new File("C:\\MyOutputFile.txt");

			instream = new FileInputStream(destinationFile);
			outstream = new FileOutputStream(ToFile);

			byte[] buffer = new byte[1024];

			int length;
			/*copying the contents from input stream to
			 * output stream using read and write methods
			 */
			while ((length = instream.read(buffer)) > 0){
				outstream.write(buffer, 0, length);
			}

			//Closing the input/output file streams
			instream.close();
			outstream.close();

			System.out.println("File copied successfully!!");

		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
