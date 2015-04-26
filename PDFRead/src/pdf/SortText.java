/**   
* @Title: SortText.java 
* @Package pdf 
* @Description: sort text to element which in form of A:aaaaaa'\n' 
* resource can be
* "Booking Ref: PTCB023863
* Lic. No: 2TA4399   ABN No: 32 054 307 158
* CZ381Fri 9 Jan 15 2110/0830+1GUANGZHOU/BRISBANE
* 21S Adt: 11 Chd: 4 Infant: 0 T/L: 1 L/G: 1"
* @author 肖任 434835764@qq.com   
* @date 2015年2月10日 下午11:57:01 
* @version V1.0   
*/
package pdf;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.lucene.search.Sort;
import org.pdfbox.util.operator.NextLine;

import strategy.ISort2String;
import strategy.ISort2Strings;
import strategy.SortFunc;
import strategy.StringFactory;
import tool.data2excel.WriteSheet;
import tool.strings.StringArray;

/**
 * @author xiaoren
 *
 */
public class SortText
{
	private	String 	fileString = null;
	private	String[] fileStrings ;
	private	String[] elementNames ;
	private	String[] elementContents ;
	private String  elementStringA = null;
	private String  elementStringB = null;
	private String  elementStringC = null;
	private int  index = 0;
	SortText(String aa){
		fileString = aa;
		if (fileString!= null)
		{
			fileStrings = fileString.split("\r\n");
		}
		else
		{
			System.out.println("SortText.fileString is null");
		}
	}
	
	/** 
	 * @Title: getline 
	 * @Description:读取一行
	 * @param     设定文件 
	 * @return     String 
	 * @throws 
	 */
	private String getline()
	{
		elementStringB = fileStrings[index];
		return elementStringB;
	}
	
	/**
	 * @return the index
	 */
	public int getLineNum()
	{
		return index;
	}
	
	public void nextLine(){
		if (index<fileStrings.length)
		{
			index++;
		}	
	}
	
	/**
	 * @return the elementStringA
	 */
	public String getElementStringA()
	{
		if (fileString!= null&&index>=1)
		{
			elementStringA = fileStrings[index-1];
		}
		else 
		{
			System.out.println("SortText.elementStringA=null");
		}
		
		return elementStringA;
	}
	
	public String getElementStringB()
	{
		if (fileString!= null&&index<fileStrings.length-1)
		{
			elementStringB = fileStrings[index+1];
		}
		else 
		{
			System.out.println("SortText.elementStringB=null");
		}
		return elementStringB;
	}
	
	public String[] getElementName (){
		ISort2Strings  sF = new SortFunc();
		return sF.sort2Strings(elementStringB);
	}
	
	public String[] getElementContent (){
		ISort2Strings  sF = new SortFunc();
		return sF.sort2Strings(elementStringB);
	}
	
	/** 
	 * @Title: sortfile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public void sortFile()
	{
		StringArray names = new StringArray(elementNames);
		StringArray contents = new StringArray(elementContents);
		ArrayList  aa  = new  ArrayList();
		StringFactory sFactory = new StringFactory(new SortFunc());
		WriteSheet testSheet = new WriteSheet();
		if (fileStrings!=null)
		{
			for (int i = 0; i < fileStrings.length; i++)
			{
				getline();
				getElementStringB();				
				if (!aa.isEmpty())
				{
					aa.clear();
				}
				elementNames = new StringArray(elementNames).add(getElementName());
				elementContents = new StringArray(elementContents).add(getElementContent());
				sFactory.setString(getElementStringB());
				WriteSheet.write("data//command - 副本.xls", 0,sFactory.fixString());
				nextLine();
			}

		}
		else 
		{
			System.out.println("fileStrings 为空");
		}
		
	}

	

}
