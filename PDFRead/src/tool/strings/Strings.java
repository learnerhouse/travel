/**   
* @Title: Strings.java 
* @Package tool 
* @Description: 
* @author Ф�� 434835764@qq.com   
* @date 2015��4��13�� ����7:54:06 
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
	 * @Description: TODO �������е�index���ַ������ؼ���matchString�ָ�������µ����飬Ԫ�ظ�������һ��
	 * @param     �趨�ļ� 
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
	 * @Description: ������Strings���ַ����в�ѯ����ƥ���ַ�matchStringʱ�����и������Ԫ��
	 * @param     �趨�ļ� 
	 * @return void    �������� 
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
	 * @Description: ����ַ����Ƿ����һ��h:mm��ʽ��ʱ���ַ���
	 * @param     �趨�ļ� 
	 * @return  int û�з���-1�����򷵻ظĸ�ʽ�ַ�������ʼλ��
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
				System.out.println("IsContainFormatOfString �ַ���Ϊ�գ�");
				return -1;
			}

		default:
			return -1;
		}	
	}

}
