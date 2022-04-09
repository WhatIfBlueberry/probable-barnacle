import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class TableDataObject {

	String title;
	String description;
	String rating;
	String categories;

	public TableDataObject(Text title2, Combo rating2, Combo categories2, Text description2) {
		title = title2.getText();
		rating = rating2.getText();
		categories = categories2.getText();
		description = description2.getText();
	}
	
}
