package exam_factory;

public class ExamSF {
	private static IServiceFactory fact_impl;

	public void setImpl(IServiceFactory fact) {
		fact_impl = fact;
	}

	public static IServiceFactory Service() {
		try {
			if (fact_impl == null) {
				fact_impl = (IServiceFactory) Class.forName(
						"exam_factory.impl.ServiceFactory")
						.newInstance();
			}
			return fact_impl;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
}
