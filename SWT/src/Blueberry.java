import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;



public class Blueberry {

	Text title;
	Text description;
	Combo rating;
	Combo categories;
	Table table;

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
		Shell tableShell = new Shell(display);
		Shell shell = new Shell(display);
		GridLayout grid = new GridLayout();
		grid.numColumns = 4;
		shell.setLayout(grid);
		shell.setText("Blueberry");

		new Label(shell,SWT.SHADOW_IN).setText("Titel: ");
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

		showTableButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				tableShell.open();
				//geht so nicht aber sehr interesting das ich zugriff auf tableShell habe!
			}
		});
		enterButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				safeInputToFile();
				addInputToTable();
				clearInput();
			}

		});
		//enterButton.addSelectionListener(enterListener);

		shell.pack();
		return shell;

	}
	private void addInputToTable() {

		Shell tableShell = new Shell();
		tableShell.setText("Große Tabelle mit einer Menge tollen Daten");
		Table table = new Table(tableShell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] titles = { " ", "C", "!", "Description", "Resource",
				"In Folder", "Location" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}
		int count = 128;
		for (int i = 0; i < count; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, "x");
			item.setText(1, "y");
			item.setText(2, "!");
			item.setText(3, "this stuff behaves the way I expect");
			item.setText(4, "almost everywhere");
			item.setText(5, "some.folder");
			item.setText(6, "line " + i + " in nowhere");
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		table.setSize(table.computeSize(SWT.DEFAULT, 200));
		tableShell.pack();
		tableShell.open();
	}

	private void clearInput() {
		title.setText("");
		description.setText("");
		categories.setText("");
		rating.setText("From 1-5");
	}

	private void safeInputToFile() {
		try {
			List<String> lines = Arrays.asList(title.getText() +
					description.getText() + 
					rating.getText() + 
					categories.getText());
			Path file = Paths.get("the-file-name.txt");
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("An error	 occurred.");
			e.printStackTrace();
		}

	}

}
