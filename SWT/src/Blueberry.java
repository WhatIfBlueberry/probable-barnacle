import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



public class Blueberry {
	
	Text title;
	Text description;
	Combo rating;
	Combo categories;

	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Blueberry().createMainWindow(display);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public Shell createMainWindow(final Display display) {
		Shell shell = new Shell(display);
		GridLayout grid = new GridLayout();
		grid.numColumns = 3;
		shell.setLayout(grid);
		shell.setText("Blueberry");
		
		new Label(shell,SWT.SHADOW_IN).setText("Titel: ");
		GridData titleLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		titleLayout.horizontalSpan = 2;
		title = new Text(shell, SWT.SINGLE | SWT.BORDER);
		title.setLayoutData(titleLayout);
		
		new Label(shell,SWT.SHADOW_IN).setText("Rating: ");
		rating = new Combo(shell, SWT.NONE);
		GridData ratingLayout = new GridData(GridData.FILL, GridData.CENTER, false, false);
		ratingLayout.horizontalSpan = 1;
		rating.setLayoutData(ratingLayout);
		rating.setItems(new String[] {"1", "2", "3", "4", "5" });
		rating.setText("From 1-5");
		
		Button enterButton = new Button(shell, SWT.PUSH);
		GridData enterButtonLayout = new GridData(GridData.FILL, GridData.FILL, true, false);
		//openDescriptionLayout.horizontalSpan = 1;
		enterButtonLayout.verticalSpan = 2;
		enterButton.setLayoutData(enterButtonLayout);
		enterButton.setText("Enter");
		
		Label chooseCategory = new Label(shell, SWT.SHADOW_IN);
		GridData chooseCategoryLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		chooseCategoryLayout.horizontalSpan = 1;
		chooseCategory.setLayoutData(chooseCategoryLayout);
		chooseCategory.setText("Choose Category");
		
		categories = new Combo(shell, SWT.NONE);
		GridData categoriesLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		categoriesLayout.horizontalSpan = 1;
		categories.setLayoutData(categoriesLayout);
		categories.setText("Categories");
		categories.setItems(new String[] {"Restaurants", "Filme / Serien", "Kochen", "Wunschliste", "Remind-me"});
		
		
		description = new Text(shell, SWT.MULTI | SWT.BORDER);
		GridData descriptionLayout = new GridData(GridData.FILL, GridData.FILL, false, true);
		descriptionLayout.horizontalSpan = 3;
		descriptionLayout.heightHint = 7 * description.getLineHeight();
		descriptionLayout.grabExcessVerticalSpace = true;
		description.setLayoutData(descriptionLayout);
		
		SelectionListener enterListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				System.out.println(title.getText() +
				description.getText() + 
				rating.getText() + 
				categories.getText());
				
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		};
		
		enterButton.addSelectionListener(enterListener);
		
		shell.pack();
		return shell;
		
	}

}
