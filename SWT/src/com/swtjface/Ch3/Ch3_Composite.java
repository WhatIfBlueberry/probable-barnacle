package com.swtjface.Ch3;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Ch3_Composite extends Composite {
	public Ch3_Composite(Composite parent) {
		super(parent,SWT.NONE);
		parent.getShell().setText("Chapter 3 Composite");
		Ch3_Group cc1 = new Ch3_Group(this);
		cc1.setLocation(0,0);
		cc1.pack();

		pack();
	}
}
