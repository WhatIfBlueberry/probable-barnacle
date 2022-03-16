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
		
		Shell dialog = new Shell();

		
		GridLayout grid = new GridLayout();
		grid.numColumns = 3;
		shell.setLayout(grid);
		
		GridLayout grid2 = new GridLayout();
		grid2.numColumns = 2;
		dialog.setLayout(grid2);
		
		Label shadow_label = new Label(shell, SWT.CENTER);
		shadow_label.setText("Ich bin ein Label");
		
		
		Button button1 = new Button(shell, SWT.TOGGLE);
		button1.setText("Ich bin ein Toggle");
		
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Ich bin ein Button");
		
		button2.addSelectionListener(SelectionListener.widgetSelectedAdapter(e-> dialog.open()));
		
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
		//radio[1].set
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
					if (btn.getText().equals("checked")) {
						btn.setText("unchecked");
						btn.pack();
						dialog.pack();
					}
					else if (btn.getText().equals("unchecked")) {
						btn.setText("checked");
						btn.pack();
						dialog.pack();
					}
					else {
						btn.setText("checked");
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
