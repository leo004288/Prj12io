package ex03;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream {

	public static void main(String[] args) throws IOException {
		
		String path = 
			TestInputStream.class.getResource("").getPath(); 
//		System.out.println(path); // 실행되는 클래스의 위치
		String inFile = path + "data2.dat";
		
		FileInputStream fis = new FileInputStream(inFile);
		
		int ch;
		while ((ch = fis.read()) != -1) {    // EOF = Enf Of File(-1) 이 아닐동안 반복
			System.out.print( (char) ch );
		}
		
		fis.close();
		
	} //

} //
