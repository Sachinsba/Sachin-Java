package InnerClass;

//anonymous inner class
abstract class anonymousInnerClass3{
	public abstract void display();
}


public class InnerClass3 {

	public static void main(String[] args) {
		anonymousInnerClass3 i = new anonymousInnerClass3() {

			public void display() {
				System.out.println("Anonymous Inner Class");
			}
		};
		i.display();
	}
}

