package com.rits;



public class MagicBoxImpl implements MagicBox {
	
	public MagicBoxImpl() {
		super();
		System.out.println(" MagicBox Impl constructor invoked");
		
	}

	@Override
	public String getContents() {
		
			return "A beautiful Assitant";
		
	}

}
