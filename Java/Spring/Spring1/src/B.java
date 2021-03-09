
public class B {
	C c ;
	B(C c){
		this.c = c;
		System.out.println("B created with C");
	}
	B(C c, D d){
		this.c = c;
		System.out.println("B created with both C and D");
	}

}
