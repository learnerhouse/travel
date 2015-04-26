/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tool.data2excel;

import java.sql.Time;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author lv
 */
public class data2excel {

	private String aa =null;
	public data2excel(String aa)
	{
		this.aa=aa;		
	}
	
	public void SetPath(String aa)
	{
		this.aa = aa;
		
	}
	public void write(String cmd)
	{
		Date date = new Date();
		WriteSheet ws = new WriteSheet(); 
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s=format.format(date);
        ArrayList list = new ArrayList();
        list.add(s);
        String [] cmds = cmd.split(" ");
        for (int i = 0; i < cmds.length; i++) {
			list.add(cmds[i]);
		}
        ws.write(aa,0,list);
	}
	
	public void write(String[] cmd)
	{
		Date date = new Date();
		WriteSheet ws = new WriteSheet(); 
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s=format.format(date);
        ArrayList list = new ArrayList();
        list.add(s);
        list.add("aa");
        list.add("bb");
        String [] cmds = cmd;
        for (int i = 0; i < cmds.length; i++) {
			list.add(cmds[i]);
		}
        ws.write(aa,0,list);
	}

    public static void main(String[] args)
	{
		new data2excel("aa.xls").write("haha");
	}
}
