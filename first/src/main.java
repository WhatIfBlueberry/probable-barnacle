import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class main {

	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell();
		
		shell.setLayout(new GridLayout());
		shell.setText("First Program of its kind, long!");
		
		Text text = new Text(shell, SWT.SHADOW_ETCHED_OUT);
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Foo");
		button.pack();
		
		
		//button.addSelectionListener(SelectionListener.widgetSelectedAdapter(e-> System.out.println("Pressed")));
		
		text.setText("Hello oh you wonderfull world!");
		text.pack();
		
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

}
