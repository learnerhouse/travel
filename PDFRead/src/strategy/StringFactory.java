/**   
* @Title: StringFactory.java 
* @Package strategy 
* @Description: 
* @author 肖任 434835764@qq.com   
* @date 2015年2月12日 下午2:19:58 
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
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param     设定文件 
	 * @return void    返回类型 
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
			System.out.println("StringFactory的fileString为空！");
		}
		
		for (int i = 0; i < fileStrings.length; i++)
		{
			cellStrings.add(fileStrings[i]);
		}
		
		return cellStrings;

	}
	
	
	
}
