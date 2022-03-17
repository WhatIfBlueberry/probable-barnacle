package com.swtjface.Ch3;
import org.eclipse.jface.window.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class CompViewer extends ApplicationWindow 
{
	public CompViewer() 
	{
		super(null);
	}
	protected Control createContents(Composite parent) 
	{
		new Ch3_Composite(parent);
		return parent;
	}
	public static void main(String[] args) 
	{
		CompViewer cv = new CompViewer();
		cv.setBlockOnOpen(true);
		cv.open();
		Display.getCurrent().dispose();
	}
}