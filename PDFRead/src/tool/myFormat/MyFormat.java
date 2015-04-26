/**   
* @Title: MyFormat.java 
* @Package tool.MyFormat 
* @Description: 
* @author 肖任 434835764@qq.com   
* @date 2015年4月13日 下午9:35:02 
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
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param     设定文件 
	 * @return void    返回类型 
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
	 * @Description: 是否是时间h:mm的格式
	 * @param     设定文件 
	 * @return void    返回类型 
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
