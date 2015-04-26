/**   
* @Title: Strings.java 
* @Package tool 
* @Description: 
* @author 肖任 434835764@qq.com   
* @date 2015年4月13日 下午7:54:06 
* @version V1.0   
*/
package tool.strings;

import java.text.SimpleDateFormat;

import tool.Log;
import tool.myFormat.MyFormat;


/**
 * @author xiaoren
 *
 */
public class Strings
{
	/** 
	 * @Title: splitStrings 
	 * @Description: TODO 将数组中第index个字符串按关键字matchString分割，并产生新的数组，元素个数增加一个
	 * @param     设定文件 
	 * @return void    String[]
	 * @throws 
	 */
	public static String[] splitIndexOfStringsWhenMSHappened(String [] aaStrings ,int index,String matchString)
	{
		String[] bbStrings,ccStrings =null  ;
		int j = 1;
		if (aaStrings!=null)
		{
			bbStrings = aaStrings[index].split(matchString);
			ccStrings = new StringArray(aaStrings).add(aaStrings[aaStrings.length-1]);			
			for (int i = bbStrings.length; i >= index; i--)
			{
				if (i>index+1)
				{
					ccStrings[i] = ccStrings[i-1];
				} else
				{		
					ccStrings[i] = bbStrings[j];
					j--;
				}
			}
		}
		else 
		{
			System.out.println("splitSubString.aaStrings is null");
		}
		return ccStrings;
	}
	
	/** 
	 * @Title: splitWhen__happen 
	 * @Description: 在数组Strings的字符串中查询到有匹配字符matchString时将其切割成两个元素
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static String [] splitWhenMShappen(String[] elements,String matchString)
	{
		if (elements!=null)
		{
			int len = elements.length;
			for (int i = 0; i < len; i++)
			{
				if (elements[i].contains(matchString))
				{
					elements = Strings.splitIndexOfStringsWhenMSHappened(elements,i,"  ");
				}
			}
		}
		
		return elements;
	}
	
	/** 
	 * @Title: IsContainFormatOfString 
	 * @Description: 检测字符串是否包含一个h:mm格式的时间字符串
	 * @param     设定文件 
	 * @return  int 没有返回-1，有则返回改格式字符串的起始位置
	 * @throws 
	 */
	public static int IsContainFormatOfString(String ss, String Format)
	{
		String temp = null;
		switch (Format)
		{
		case "h:mm":
			if (ss!=null)
			{
				int key = ss.indexOf(':');
				if (key!=0&&key!=-1&&(key+3)<=ss.length())
				{
					Log.console(key);
					temp = ss.substring(key-1, key+3);
					if( MyFormat.IsTimeOf_h_mm(temp))
					{
						return key-1;
					};
				}
				
				return -1;
			}
			else 
			{
				System.out.println("IsContainFormatOfString 字符串为空！");
				return -1;
			}

		default:
			return -1;
		}	
	}

}
