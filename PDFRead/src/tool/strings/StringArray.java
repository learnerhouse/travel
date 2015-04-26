package tool.strings;

/*
 * 数组操作：
 * 如将字符串添加在数组
 * 或者数组合并
 * 
 * 
 * */
public class StringArray {
	
	private static String[] aa;
	private static String[] bb;

	public StringArray(String []aa)
	{
		this.aa= aa;	
	}
	
	
	int getlength()
	{
		if(aa!=null){return aa.length;}
		else 
		{
			return 0;
		}
	}
	
	
	
	
	public String[]	add(String[] bb)
	{
		int org=getlength(); 
		
		int add_len =bb.length;
		
		String[] cc = new String [org+add_len];
		for(int i=0;i<org+add_len;i++ )
		{
			if(i<getlength()){cc[i]=this.aa[i];}
			if(i>=getlength()){cc[i]=bb[i-org];}			
		}
		
		return cc;
	}
	
	public String[]	add(String bb)
	{
		String[] cc = new String [getlength()+1];
		for(int i=0;i<getlength()+1;i++ )
		{
			if(i<getlength()){cc[i]=this.aa[i];}
			if(i>=getlength()){cc[i]=bb;}			
		}
		
		return cc;
	}
	
	
public 	String [] subArray(int col_begin,int col_end )
	{
		String [] subString = new String [col_end-col_begin];
		
		for(int i=0;i<subString.length;i++)
		{
			subString [i] = aa[col_begin+i];			
		}
				
		return subString;
	}
//将一个数组分为两个子数组进行重排
public String [] col_recompose (int left_col_begin,int left_col_end,int right_col_begin,int right_col_end)
{
	String[] fatherString = new StringArray(aa).subArray(left_col_begin, left_col_end);
	String[] childString = new StringArray(aa).subArray(right_col_begin, right_col_end);
	String[] recomposeStrings = new StringArray(fatherString).add(childString);		
	return recomposeStrings;
}

//将两个数组的子数组进行重排
public String [] col_recompose (String[] bb,int aa_col_begin,int aa_col_end,int bb_col_begin,int bb_col_end)
{
	String[] fatherString = new StringArray(aa).subArray(aa_col_begin, aa_col_end);
	String[] childString = new StringArray(bb).subArray(bb_col_begin, bb_col_end);
	String[] recomposeStrings = new StringArray(fatherString).add(childString);		
	return recomposeStrings;
}
	
//	public static void main(String[] args){
//		
//		String[] aa =
//		{"nihjao","hahaha","nihjao","hahaha","nihjao","hahaha","nihjao","hahaha"};
//		String bb="nihao";
//		show.string(new StringArray(aa).subArray(2, 5));//显示添加字符串后的字符串	
//	}
	
//	public static void main(String[] args) 
//	{
//		
//		String[] a = {"hello","nihao","da","ping","guo"};	
//		//将一个数组分为两个子数组进行重排
//		show.string((new sendListArray(a).col_recompose(0, 1, 2, 4)));
//	}	
	
	

}
