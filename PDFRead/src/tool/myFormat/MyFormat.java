/**   
* @Title: MyFormat.java 
* @Package tool.MyFormat 
* @Description: 
* @author Ф�� 434835764@qq.com   
* @date 2015��4��13�� ����9:35:02 
* @version V1.0   
*/
package tool.myFormat;

import tool.Log;

/**
 * @author xiaoren
 *
 */
public class MyFormat
{
	/** 
	 * @Title: IsDigtal 
	 * @Description: TODO(������һ�仰�����������������) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws 
	 */
	public static boolean IsDigtal(char key)
	{
		boolean ID = false;
		switch (key)
		{
			case '0':ID = true; return ID; 
			case '1':ID = true; return ID;
			case '2':ID = true; return ID;
			case '3':ID = true; return ID;
			case '4':ID = true; return ID;
			case '5':ID = true; return ID;
			case '6':ID = true; return ID;
			case '7':ID = true; return ID;
			case '8':ID = true; return ID;
			case '9':ID = true; return ID;
			default: return ID;
		}
	}
	/** 
	 * @Title: IsDigtal 
	 * @Description: �Ƿ���ʱ��h:mm�ĸ�ʽ
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws 
	 */
	public static boolean IsTimeOf_h_mm(String key)
	{
		if (key.contains(":"))
		{
			int index=0;
			index = key.indexOf(":");
			if (IsDigtal(key.charAt(index-1))&&IsDigtal(key.charAt(index+1))&&IsDigtal(key.charAt(index+2)))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args)
	{
		Log.console(IsTimeOf_h_mm("2:30"));
	}
	
}
