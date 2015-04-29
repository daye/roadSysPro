package exam_tools;

import java.io.File;

public class HibernateValueHelper {
	
	private static StringBuffer str = new StringBuffer(1024*1024);
		
//	<value>oil/base/entity/CommonCode.hbm.xml</value>
	public void gen(String xmlpath) {
		java.io.File path=new java.io.File(xmlpath);
		File[] files=path.listFiles();
		for(int i=0;i<files.length;i++)
		{
			File f=files[i];
			if(f.isDirectory())				
			{
				gen(f.getAbsolutePath());
			}
			if(f.getAbsolutePath().endsWith(".hbm.xml")==true)
			{
				String absolutePath = f.getAbsolutePath();				
				String retAbsolutePath = absolutePath.substring(absolutePath.indexOf("\\oil\\")+1);
				str.append("<value>"+retAbsolutePath.replace('\\', '/')+"</value>\n");
			}
		}
	}
	

	
	public static void main(String[] args) {
		String path="./src/server/";
		new HibernateValueHelper().gen(new File(path,"oil").getAbsolutePath());
		System.out.println(str.toString());
	}

}
