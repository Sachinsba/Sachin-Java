package Constructor;

public class ParameterizedConstructorMain {
	public static void main(String[] args) {
		ParameterizedConstructor pc = new ParameterizedConstructor();
		pc.disp(15, "sachin", 50000f);
		System.out.println(pc.getId());
		System.out.println(pc.getName());
		System.out.println(pc.getSalary());
	}
}
