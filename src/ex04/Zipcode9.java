package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode9 {

	public static void main(String[] args) {
		
//		String path     = Zipcode8.class.getResource("").getPath();
		String path     = "D:/dev/java/Prj12io/Src/ex04/";
		String inFname  = "zipcode_utf8.csv"; 
		String outFname = ""; 
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		int cnt = 0;
		try {
			fr = new FileReader(path + inFname);
			br = new BufferedReader(fr);

			br.readLine();
			String line = "";
			String prevSido = "";
			while ( (line = br.readLine()) != null) {
				PostVo postvo = new PostVo(line);
				String sido   = postvo.getSido();

				if( !sido.equals(prevSido) ) {
					
					if(bw !=null) bw.close();
					if(fw !=null) fw.close();
					
					outFname = path = sido + ".csv";
					File oFile = new File(outFname);
					if (oFile.exists()) {
						oFile.delete();
					}
					fw = new FileWriter(oFile, true);
					bw = new BufferedWriter(fw);
					
					prevSido = sido;
					cnt++;
				} 
				
				bw.write( postvo.getAddress() + "\n" );
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(bw != null) bw.close();
				if(fr != null) fr.close();
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		System.out.println(cnt + "개 파일 생성");
		
		
		
	}

}
