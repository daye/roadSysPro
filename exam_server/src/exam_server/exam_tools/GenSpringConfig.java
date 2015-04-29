package exam_tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenSpringConfig {

	/**
	 * 获取spring所要加载的所有配置,在config下
	 * @param path
	 * @return
	 */
	public String[] getSpringConfigs(String path)
	{
		return this.gen(path);
	}
	
	
	private String[] gen(String xmlpath) {
		List nameLst = new ArrayList();
		java.io.File path=new java.io.File(xmlpath);
		File[] files=path.listFiles();
		if(files == null)
			return new String[]{};	
		 String osName = System.getProperty("os.name").toLowerCase();
		for(int i=0;i<files.length;i++)
		{
			File f=files[i];
			if(f.isDirectory())				
			{
				String[] retDic = gen(f.getAbsolutePath());
				nameLst.addAll(Arrays.asList(retDic));
			}
			if(f.getAbsolutePath().endsWith(".xml")==true && f.getAbsolutePath().indexOf("app-")>=0)
			{
				String absolutePath = f.getAbsolutePath();
				String fileName="";
				if(osName.startsWith("windows"))
					fileName = absolutePath.substring(absolutePath.indexOf("\\config\\")+1);
				else
					fileName = absolutePath.substring(absolutePath.indexOf("/config/"));
				fileName = fileName.replace('\\', '/');
				nameLst.add(fileName);
			}
		}
		if(nameLst.size()>0)
		{
			String[] retLst = new String[nameLst.size()];
			nameLst.toArray(retLst);
			return retLst;			
		}
		return new String[]{};
	}
	
	
	public static void main(String[] args) {
		String path="./src/server/config/";
		String [] ret = new GenSpringConfig().getSpringConfigs(new File(path,"").getAbsolutePath());
		for(int i=0 ; i<ret.length; i++)
		{
			System.out.println(ret[i]);
		}
	}
}
