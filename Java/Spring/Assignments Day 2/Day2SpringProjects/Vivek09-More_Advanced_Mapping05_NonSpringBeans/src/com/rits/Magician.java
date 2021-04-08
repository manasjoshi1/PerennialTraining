package com.rits;

import org.springframework.beans.factory.annotation.Configurable;
@Configurable("magician1")
public class Magician {
	String magicwords;
	MagicBox box;
	
	public String getMagicwords() {
		return magicwords;
	}

	public void setMagicwords(String magicwords) {
		this.magicwords = magicwords;
	}


	public MagicBox getBox() {
		return box;
	}

	public void setBox(MagicBox box) {
		this.box = box;
	}

	@Override
	public String toString() {
		return "Magician [MagicBox=" + box + ", magicwords=" + magicwords
				+ "]";
	}

	public void perform(){
		System.out.println(magicwords);
		System.out.println(getBox().getContents());
		
	}

}
