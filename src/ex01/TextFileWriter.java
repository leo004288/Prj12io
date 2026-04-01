package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

	public static void main(String[] args) throws IOException {
		
		String [] names = {"Rm","진","슈가","제이홉","지민","뷔","정국"};
		
//		String filename = "bts.txt";
		String filename = "D:\\dev\\java\\Prj12io\\src\\ex01\\bts.txt";
		FileWriter fw = new FileWriter(filename);
		for (int i = 0; i < names.length; i++) {
			fw.write((i+1) + "." + names[i] + "\n");						
		}
//		fw.write(names[1] + "\n");
//		fw.write(names[2] + "\n");
		fw.close();
		
		
		System.out.println(filename + "이 " + names.length + "줄 저장");
		
	} //

} //
