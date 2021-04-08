package com.rits;

public  abstract class Magician {
	String magicwords;
	MagicBox box;
	
	public String getMagicwords() {
		return magicwords;
	}

	public void setMagicwords(String magicwords) {
		this.magicwords = magicwords;
	}


	abstract public MagicBox getBox() ;
	abstract public MagicBox getBox2() ;

//	public void setBox(MagicBox box) {
	//	this.box = box;
	//}

	
	/*public String toString() {
		return "Magician [MagicBox=" + box + ", magicwords=" + magicwords
				+ "]";
	}*/

	public void perform(){
		System.out.println(magicwords);
		System.out.println(this);
		System.out.println(getBox().getContents());
		Object o = getBox2();
		System.out.println(o);
	}

}
