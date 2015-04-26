/**   
* @Title: SortFunc.java 
* @Package pdf 
* @Description: 
* @author Ф�� 434835764@qq.com   
* @date 2015��2��11�� ����12:23:05 
* @version V1.0   
*/
package strategy;

import tool.Log;
import tool.myFormat.MyFormat;
import tool.strings.StringArray;
import tool.strings.Strings;


/**
 * @author xiaoren
 *
 */
public class SortFunc implements ISort2Strings
{
	String[] elements ;
	String 	 element ;

	/* (non-Javadoc)
	 * @see pdf.ISortFunc#sortFunc()
	 */
	@Override
	public String[] sort2Strings(String element)
	{
		if (element!=null)
		{	
			this.element = element;
			int a =Strings.IsContainFormatOfString(element,"h:mm");
			if ( a!=-1)
			{
				StringBuilder sb=new StringBuilder(element);
				sb.insert(a+4,"@");
				Log.console(sb.toString());
				elements = sb.toString().split("@");
			}
			else 
			{
				elements = element.split(":");
			}
			if (elements!=null&&elements.length>=3)
			{
				elements=Strings.splitWhenMShappen(elements,"  ");
			}
			else 
			{
				System.out.println("��Ҫ�����㷨��");
			}
			
		}
		else
		{
			System.out.println("SortFunc��elementΪ�գ�");
		}
		
		
		return this.elements;
	}
	
	
public static void main(String[] args)
{
	String[] aaString  = {"Lic. No"," 2TA4399   ABN No"," 32 054 307 158"};
	String[] bbStrings = Strings.splitIndexOfStringsWhenMSHappened(aaString,1,"  ");
	for (int i = 0; i < bbStrings.length; i++)
	{
		System.out.println(bbStrings[i]);
	}
}
	
	
}
