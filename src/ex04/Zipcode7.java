package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode7 {

	public static void main(String[] args) {
		
		String fn = "D:/dev/java/Prj12io/Src/ex04/zipcode_utf8.csv";
		
		FileReader     fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fn);
			br = new BufferedReader(fr);
			
			br.readLine();
			String line = "";
			while ( (line = br.readLine()) != null) {
				PostVo postvo = new PostVo(line);
				String sido = postvo.getSido(); 
				String dong = postvo.getDong(); 
				
			    if ( sido.equals("부산") && dong.startsWith("부전2동") ) {
			    	System.out.println(postvo);
			    }
			    
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(fn + " 파일이 없습니다");
			
		} catch (IOException e) {
			System.out.println("데이터 입력에 문제가 있습니다");
		} catch (Exception e) {
			System.out.println("문제발생:" + e.getMessage());	
		} finally {  // exception 발생과 상관없이 실행
			try {
				if(br != null) br.close();
				if(br != null) fr.close();
			} catch (IOException e) {}
		}
		
		System.out.println("작업끝");
		
		
		
	} //

} //
