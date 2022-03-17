

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;


public class LabelLuder {

	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell();
		shell.setText("Toggle first!");
		Shell dialog = new Shell();

		
		GridLayout grid = new GridLayout();
		grid.numColumns = 3;
		shell.setLayout(grid);
		
		GridLayout grid2 = new GridLayout();
		grid2.numColumns = 2;
		dialog.setLayout(grid2);
		
		Label shadow_label = new Label(shell, SWT.CENTER);
		shadow_label.setText("Ich bin ein Label");
		
		Button toggle = new Button(shell, SWT.TOGGLE);
		toggle.setText("Ich bin ein Toggle");
		
		Button push = new Button(shell, SWT.PUSH);
		push.setText("Ich bin ein Button");
		
		toggle.addSelectionListener(SelectionListener.widgetSelectedAdapter(e -> {
			if(toggle.getSelection() == false && push.getText().equals("Well done Sir")) {
				push.setText("Nope, try again");
				shell.pack();
			}
			else {
				push.setText("Well done Sir");
			}
		}));
		
		push.addSelectionListener(SelectionListener.widgetSelectedAdapter(e-> {if(toggle.getSelection()) {
			dialog.open();}
			else {
				push.setText("Please Toggle first");
				shell.pack();
			}
		}));
		
		SelectionListener checkButtonListener = checkButtons(dialog);
		
		
		Button[] checks = new Button[2];
		checks[0] = new Button(dialog, SWT.CHECK);
		checks[0].addSelectionListener(checkButtonListener); 
		checks[0].setText("Choice 1");
		checks[0].pack();
		checks[1] = new Button(dialog, SWT.CHECK);
		checks[1].addSelectionListener(checkButtonListener); 
		checks[1].setText("Choice 2");
		checks[1].pack();
		
		Button[] radio = new Button[2];
		radio[0] = new Button(dialog,SWT.RADIO);
		radio[0].setText("Hellow");
		radio[0].addSelectionListener(checkButtonListener);
		radio[0].pack();
		radio[1] = new Button(dialog,SWT.RADIO);
		radio[1].setText("Hellow");
		radio[1].addSelectionListener(checkButtonListener);
		radio[1].pack();
		
		dialog.pack();
		shell.pack();
		shell.open();
		
		while (!shell.isDisposed()) { 
		    if (!display.readAndDispatch()) 
		     { display.sleep();} 
		}
		display.dispose();

	}

	private static SelectionListener checkButtons(Shell dialog) {
		SelectionListener checkButtonListener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object obj = e.getSource();
				if (obj instanceof Button) {
					Button btn = (Button) obj;
					if (btn.getSelection() == true) {
						btn.setText("selected");
						btn.pack();
						dialog.pack();
					}
					else {
						btn.setText("not selected");
						btn.pack();
						dialog.pack();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return checkButtonListener;
	}

}
