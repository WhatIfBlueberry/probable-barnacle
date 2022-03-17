package com.swtjface.Ch3;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class Ch3_Group extends Composite 
{
	public Ch3_Group(Composite parent) 
	{
		super(parent, SWT.NONE);
		GridLayout grid = new GridLayout();
		Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
		group.setLayout(grid);
		grid.numColumns = 1;
		group.setText("Group Label");
		Label label = new Label(group, SWT.NONE);
		label.setText("Two buttons:");
		label.pack();		
		Button button1 = new Button(group, SWT.PUSH);
		button1.setText("Push button");
		button1.pack();
		Button button2 = new Button(group, SWT.CHECK);
		button2.setText("Check button");
		group.pack();
	}
}