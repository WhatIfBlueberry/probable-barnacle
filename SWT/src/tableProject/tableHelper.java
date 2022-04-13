package tableProject;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class tableHelper {

	Table table;
	Shell tableShell;
	List<InputTableDataObject> inputData = new ArrayList<>();

	protected void addInputToTable(InputTableDataObject input) {
		inputData.add(input);
	}

	protected void openTableShell() {
		createTableAndShell();
		populateTable();
		table.setSize(800, 500);
		tableShell.pack();
		tableShell.open();
	}

	private void createTableAndShell() {
		tableShell = new Shell();
		tableShell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableShell.setText("Big Table duh");
		table = new Table(tableShell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
	}

	//very static way of setting Column Width - update in the Future if possible!
	private void populateTable() {
		String[] titles = {"Title", "Rating", "Category", "Description"};
		Integer[] titleWidth = {180, 80, 100, 430};

		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.FILL);
			column.setText(titles[i]);
			column.setWidth(titleWidth[i]);
		}

		for (InputTableDataObject input : inputData) {
			TableItem item = new TableItem(table, SWT.FILL);
			item.setText(0, input.title);
			item.setText(1, input.rating);
			item.setText(2, input.categories);
			item.setText(3, input.description);
		}
	}
	

}
