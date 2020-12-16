package jdbcdemo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class petTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;
	private static final int PHONE_COL = 3;

	private String[] columnNames = { "owerFirstName", "ownerLastName", "email",
			"phoneNum" };
	
	private List<Pet> pets;
	public petTableModel(List<Pet> thePets) {
		pets = thePets;
	}
	
	
//	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

//	@Override
	public int getRowCount() {
		return pets.size();
	}

//	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

//	@Override
	public Object getValueAt(int row, int col) {

		Pet tempPet = pets.get(row);

		switch (col) {
		case FIRST_NAME_COL:
			return tempPet.getOln();
		case LAST_NAME_COL:
			return tempPet.getOfn();
		case EMAIL_COL:
			return tempPet.getEmail();
		case PHONE_COL:
			return tempPet.getPhone();
		case OBJECT_COL:
			return tempPet;
		default:
			return tempPet.getEmail();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
