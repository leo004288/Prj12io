package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileScore {

	public static void main(String[] args) throws IOException {
		
		String path     = "D:/dev/java/Prj12io/src/ex02/"; 
		String filename = "data.txt";

//		입력 파일
		FileReader     fr = new FileReader( path + filename );
		BufferedReader br = new BufferedReader(fr); 
		br.readLine();

//		출력 파일
		String      fname = "result.txt";
		FileWriter     fw = new FileWriter(path + fname); // , true
		// append : false or 생략 -> 생성되는 파일이 OverWrite -> 덮어쓰기
		//		기존 파일이 존재하면 덮어쓰고 없으면 새로 만듬
		// append : true          -> 생성되는 파일이 Append    -> 내용추가
		//		기존 파일이 존재하면 추가하고 없으면 새로 만듬
		BufferedWriter bw = new BufferedWriter(fw);
		

		String title = "번호 이름 국어 영어 수학 총점 평균\n"; 
		System.out.print(title);
		bw.write(title);

		String line = "";
		while( (line = br.readLine() ) != null ) {
//			System.out.println(line);
			String [] li = line.trim().split(",");
			int    num   = Integer.parseInt(li[0].trim());
			String name  = li[1].trim();
			int    kor   = Integer.parseInt(li[2].trim());
			int    eng   = Integer.parseInt(li[3].trim());
			int    mat   = Integer.parseInt(li[4].trim());
			int	   tot   = kor + eng + mat;
			double avg   = tot / 3.0;  // 소수이하 반올림 %.2f
//			String grand = "";
			
			String fmt   = "%d %s %d %d %d %d %.2f";
			String msg   = String.format(fmt,
					num, name, kor, eng, mat, tot, avg);
			System.out.println(msg);
			bw.write(msg);
		}
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
		
		
	} //

} //
