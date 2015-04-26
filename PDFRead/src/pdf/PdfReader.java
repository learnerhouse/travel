package pdf;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.pdfbox.pdmodel.PDDocument;
//import org.pdfbox.util.PDFTextStripper;
//
//public class PdfReader {
// public void readFdf(String file) throws Exception {
//  // �Ƿ�����
//  boolean sort = false;
//  // pdf�ļ���
//  String pdfFile = file;
//  // �����ı��ļ�����
//  String textFile = null;
//  // ���뷽ʽ
//  String encoding = "UTF-8";
//  // ��ʼ��ȡҳ��
//  int startPage = 1;
//  // ������ȡҳ��
//  int endPage = Integer.MAX_VALUE;
//  // �ļ��������������ı��ļ�
//  Writer output = null;
//  // �ڴ��д洢��PDF Document
//  PDDocument document = null;
//  try {
//   try {
//    // ���ȵ���һ��URL��װ���ļ�������õ��쳣�ٴӱ����ļ�ϵͳ
//	//ȥװ���ļ�
//    URL url = new URL(pdfFile);
//   //ע������Ѳ�����ǰ�汾�е�URL.����File��
//    document = PDDocument.load(pdfFile);
//    // ��ȡPDF���ļ���
//    String fileName = url.getFile();
//    // ��ԭ��PDF�������������²�����txt�ļ�
//    if (fileName.length() > 4) {
//     File outputFile = new File(fileName.substring(0, fileName
//       .length() - 4)
//       + ".txt");
//     textFile = outputFile.getName();
//    }
//   } catch (MalformedURLException e) {
//    // �����ΪURLװ�صõ��쳣����ļ�ϵͳװ��
//   //ע������Ѳ�����ǰ�汾�е�URL.����File��
//    document = PDDocument.load(pdfFile);
//    if (pdfFile.length() > 4) {
//     textFile = pdfFile.substring(0, pdfFile.length() - 4)
//       + ".txt";
//    }
//   }
//   // �ļ���������д���ļ���textFile
//   output = new OutputStreamWriter(new FileOutputStream(textFile),
//     encoding);
//   // PDFTextStripper����ȡ�ı�
//   PDFTextStripper stripper = null;
//   stripper = new PDFTextStripper();
//   // �����Ƿ�����
//   stripper.setSortByPosition(sort);
//   // ������ʼҳ
//   stripper.setStartPage(startPage);
//   // ���ý���ҳ
//   stripper.setEndPage(endPage);
//   // ����PDFTextStripper��writeText��ȡ������ı�
//   stripper.writeText(document, output);
//  } finally {
//   if (output != null) {
//    // �ر������
//    output.close();
//   }
//   if (document != null) {
//    // �ر�PDF Document
//    document.close();
//   }
//  }
// }
// /**
//  * @param args
//  */
// public static void main(String[] args) {
//  // TODO Auto-generated method stub
//  PdfReader pdfReader = new PdfReader();
//  try {
//   pdfReader.readFdf("PTCB023863 Itinerary.pdf");
//  } catch (Exception e) {
//   e.printStackTrace();
//  }
// }
// 
 import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


 public class PdfReader {

    /**
    * @param args
    */
    // TODO �Զ����ɷ������
	 public static String getTxt(File f) throws Exception {   
		  String ts="";   
		  try{   
			  String temp = "";   
			  PDDocument pdfdocument = PDDocument.load(f);   
			  ByteArrayOutputStream out = new ByteArrayOutputStream();   
			  OutputStreamWriter writer = new OutputStreamWriter(out);   
			  PDFTextStripper stripper = new PDFTextStripper();   
			  stripper.writeText(pdfdocument.getDocument(), writer);   
			  pdfdocument.close();   
			  out.close();   
			  writer.close();   
			  byte[] contents = out.toByteArray();   
			  ts = new String(contents);   
			  System.out.println(f.getName() + "length is:" + contents.length + "\n");   
		  }
		  catch(Exception e)
		  {   
		    e.printStackTrace();   
		  }   
		  finally
		  {   
		    return ts;   
		  }   
		 }  

        public   static   void   main(String[]   args)   throws   Exception{ 
             FileInputStream   fis   =   new   FileInputStream("Itinerary-25256.pdf"); 
             BufferedWriter writer = new BufferedWriter(new FileWriter("Itinerary-25256.txt"));
             PDFParser   p   =   new   PDFParser(fis); 
             p.parse();         
             PDFTextStripper   ts   =   new   PDFTextStripper();         
             String   s   =   ts.getText(p.getPDDocument()); 
             new SortText(s).sortFile();
             writer.write(s);
             fis.close(); 
             writer.close();
           
    }
 }
//}



