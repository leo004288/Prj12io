package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode8 {

	public static void main(String[] args) throws IOException {
		
		String path    = Zipcode8.class.getResource("").getPath();
		String fname   = "zipcode_utf8.csv";
		String fname2  = "result.csv";
		File   inFile  = new File(path + fname);
		if( !inFile.exists() ) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(path + fname2);
		BufferedWriter bw = new BufferedWriter(fw);
		
		br.readLine(); // 제목 스킵
		
		String Line   = "";
		PostVo vo   = new PostVo(Line);
		String sido = vo.getSido();
		while( (Line = br.readLine()) !=null ) {
			if ( vo.getDong().equals("부산진구") ) {
				String code = vo.getZipcode();
				System.out.println(code);
			}
		}
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
		
//		System.out.println("우편번호:" + cnt);
		
	} //

} //
