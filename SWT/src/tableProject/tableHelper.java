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
	List<TableDataObject> inputData = new ArrayList<>();

	protected void addInputToTable(TableDataObject input) {
		inputData.add(input);
	}

	protected void openTableShell() {
		createTableAndShell();
		populateTable();
		table.setSize(table.computeSize(SWT.DEFAULT, 300));
		tableShell.pack();
		tableShell.open();
	}

	private void createTableAndShell() {
		tableShell = new Shell();
		tableShell.setText("Große Tabelle mit einer Menge tollen Daten");
		table = new Table(tableShell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
	}

	private void populateTable() {
		String[] titles = {"Title", "Rating", "Category", "Description"};

		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
			column.pack();
		}

		for (TableDataObject input : inputData) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, input.title);
			item.setText(1, input.rating);
			item.setText(2, input.categories);
			item.setText(3, input.description);
		}
	}
}
