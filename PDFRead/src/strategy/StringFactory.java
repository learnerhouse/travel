/**   
* @Title: StringFactory.java 
* @Package strategy 
* @Description: 
* @author Ф�� 434835764@qq.com   
* @date 2015��2��12�� ����2:19:58 
* @version V1.0   
*/
package strategy;

import java.util.ArrayList;


/**
 * @author xiaoren
 *
 */
public class StringFactory
{
	ISort2Strings sortFunc;
	String fileString;
	String[] fileStrings;
	ArrayList<String> cellStrings = new ArrayList<String>();
	
	public 	StringFactory(ISort2Strings sortFunc){
		this.sortFunc = sortFunc;
	}
	
	/**
	 * @return the fileStrings
	 */
	public String getFileStrings()
	{
		return fileString;
	}
	
	/**
	 * @param fileStrings the fileStrings to set
	 */
	public void setString(String fileString)
	{
		this.fileString = fileString;
		System.out.println(this.fileString);
	}
	
	/** 
	 * @Title: fixString 
	 * @Description: TODO(������һ�仰�����������������) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws 
	 */
	public ArrayList<String> fixString()
	{
		if (!cellStrings.isEmpty())
		{
			cellStrings.clear();
		}
		else 
		{
			System.out.println("cellStrings.isEmpty");
		}
		
		if (fileString!=null)
		{
			fileStrings = sortFunc.sort2Strings(fileString);
		}
		else 
		{
			System.out.println("StringFactory��fileStringΪ�գ�");
		}
		
		for (int i = 0; i < fileStrings.length; i++)
		{
			cellStrings.add(fileStrings[i]);
		}
		
		return cellStrings;

	}
	
	
	
}
