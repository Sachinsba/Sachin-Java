package AccessModifiersMain;

import AccessModifiers.DefaultModifier;

public class DefaultModifierMain {
	public static void main(String[] args) {
		System.out.println("Default access modifier");
		DefaultModifier dm = new DefaultModifier();
		
		//dm.disp();//we cannot access default access modifier outside the package
	}
}
