package tableProject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
	tableHelper table = new tableHelper();

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
		grid.numColumns = 4;
		shell.setLayout(grid);
		shell.setText("Blueberry");

		new Label(shell,SWT.SHADOW_IN).setText("Title: ");
		GridData titleLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		titleLayout.horizontalSpan = 3;
		title = new Text(shell, SWT.SINGLE | SWT.BORDER);
		title.setLayoutData(titleLayout);

		new Label(shell,SWT.SHADOW_IN).setText("Rating: ");
		rating = new Combo(shell, SWT.NONE);
		GridData ratingLayout = new GridData(GridData.FILL, GridData.CENTER, false, false);
		ratingLayout.horizontalSpan = 1;
		rating.setLayoutData(ratingLayout);
		rating.setItems(new String[] {"1", "2", "3", "4", "5" });
		rating.setText("From 1-5");

		Button showTableButton = new Button(shell, SWT.PUSH);
		GridData showTableButtonLayout = new GridData(GridData.FILL, GridData.FILL, true, false);
		showTableButtonLayout.verticalSpan = 2;
		showTableButton.setLayoutData(showTableButtonLayout);
		showTableButton.setText("Show Table");

		Button enterButton = new Button(shell, SWT.PUSH);
		GridData enterButtonLayout = new GridData(GridData.FILL, GridData.FILL, true, false);
		enterButtonLayout.verticalSpan = 2;
		enterButton.setLayoutData(enterButtonLayout);
		enterButton.setText("Enter");

		new Label(shell,SWT.SHADOW_IN).setText("Choose Category: ");

		categories = new Combo(shell, SWT.DROP_DOWN);
		GridData categoriesLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		categoriesLayout.horizontalSpan = 1;
		categories.setLayoutData(categoriesLayout);
		categories.setText("Categories");
		categories.setItems(new String[] {"Restaurants", "Filme / Serien", "Kochen", "Wunschliste", "Remind-me"});

		description = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData descriptionLayout = new GridData(GridData.FILL, GridData.FILL, false, true);
		descriptionLayout.horizontalSpan = 4;
		descriptionLayout.heightHint = 7 * description.getLineHeight();
		descriptionLayout.grabExcessVerticalSpace = true;
		description.setLayoutData(descriptionLayout);

		enterButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (title.getText().isEmpty()) {
					title.setBackground(display.getSystemColor(SWT.COLOR_RED));
				}
				else {
					title.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
					table.addInputToTable(new InputTableDataObject(title, rating, categories, description));
				}
				clearInput();
			}

		});

		showTableButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				table.openTableShell();
			}
		});

		shell.pack();
		return shell;

	}


	private void clearInput() {
		title.setText("");
		description.setText("");
		categories.setText("");
		rating.setText("From 1-5");
	}

}


