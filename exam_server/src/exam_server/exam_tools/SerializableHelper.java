package exam_tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableHelper {

	public static byte[] toData(Object obj)
	{
		byte result[] = new byte[0];
		try
		{
			ByteArrayOutputStream bo = new ByteArrayOutputStream(10240);
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			if (obj.getClass().equals(Double.TYPE) || obj.getClass().equals(java.lang.Double.class))
				oo.writeDouble(((Double)obj).doubleValue());
			else
			if (obj.getClass().equals(Integer.TYPE) || obj.getClass().equals(java.lang.Integer.class))
				oo.writeInt(((Integer)obj).intValue());
			else
				oo.writeObject(obj);
			oo.close();
			result = bo.toByteArray();
			bo.close();
		}
		catch (Throwable throwable) { }
		return result;
	}
	
	public static Object toObject(byte od[])
	{
		Object r = null;
		try
		{
			ByteArrayInputStream bi = new ByteArrayInputStream(od);
			ObjectInputStream oi = new ObjectInputStream(bi);
			r = oi.readObject();
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
		return r;
	}
	
}
