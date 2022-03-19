import org.eclipse.swt.SWT;
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
		
		new Label(shell,SWT.SHADOW_IN).setText("Titel: ");
		GridData titleLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		titleLayout.horizontalSpan = 2;
		title = new Text(shell, SWT.SINGLE | SWT.BORDER);
		title.setLayoutData(titleLayout);
		
		new Label(shell,SWT.SHADOW_IN).setText("Rating: ");
		Combo rating = new Combo(shell, SWT.NONE);
		GridData ratingLayout = new GridData(GridData.FILL, GridData.CENTER, false, false);
		ratingLayout.horizontalSpan = 1;
		rating.setLayoutData(ratingLayout);
		rating.setItems(new String[] {"1", "2", "3", "4", "5" });
		rating.setText("From 1-5");
		
		Button openDescription = new Button(shell, SWT.PUSH);
		GridData openDescriptionLayout = new GridData(GridData.FILL, GridData.FILL, true, false);
		//openDescriptionLayout.horizontalSpan = 1;
		openDescriptionLayout.verticalSpan = 2;
		openDescription.setLayoutData(openDescriptionLayout);
		openDescription.setText("add Description");
		
		Label chooseCategory = new Label(shell, SWT.SHADOW_IN);
		GridData chooseCategoryLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		chooseCategoryLayout.horizontalSpan = 1;
		chooseCategory.setLayoutData(chooseCategoryLayout);
		chooseCategory.setText("Choose Category");
		
		Combo categories = new Combo(shell, SWT.NONE);
		GridData categoriesLayout = new GridData(GridData.FILL, GridData.CENTER, true, false);
		categoriesLayout.horizontalSpan = 1;
		categories.setLayoutData(categoriesLayout);
		categories.setText("Categories");
		categories.setItems(new String[] {"Restaurants", "Filme / Serien", "Kochen", "Wunschliste", "Remind-me"});
		
		
		
		description = new Text(shell, SWT.SINGLE | SWT.BORDER);
		GridData descriptionLayout = new GridData(GridData.FILL, GridData.FILL, true, true);
		descriptionLayout.horizontalSpan = 3;
		descriptionLayout.verticalSpan = 10;
		description.setLayoutData(descriptionLayout);
		
		
		shell.pack();
		return shell;
		
	}

}
