package exam_tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileAppender {

	FileOutputStream resultFile;

	public FileAppender(String destfile) {
		try {
			resultFile= new FileOutputStream(destfile,true);
			resultFile.write("".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void append(byte[] data) {
		try {
			resultFile.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void append(java.io.File file) {
		try {
			InputStream in = new FileInputStream(file);
			append(in);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void append(java.io.InputStream in) {
		try {
			int length = in.available();
			byte[] data = new byte[length];
			in.read(data);
			append(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void append(String data) {
		try {
			append(data.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeFile(){
		try{
			resultFile.flush();
			resultFile.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void append(byte[] data,int start,int endnum){
		try{
			resultFile.write(data, start, endnum);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
