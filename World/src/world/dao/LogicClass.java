package world.dao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.Connection;

import world.ConnectionManager;
import world.domain.City;

@SuppressWarnings("serial")
public class LogicClass extends JFrame implements ActionListener {

	// Initializing Components
	JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6;
	JTextField tf, tf1, tf2, tf3, tf4, tf5;
	JButton btnInsert, btnUpdate, btnDelete, btnSearch;

	JTable table;
	JScrollPane scrollPane;
	JPanel topPanel;
	CityTableModel cityTable = new CityTableModel();
	CityDao dao = new CityDao();
	ConnectionManager obj = new ConnectionManager();

	// Creating Constructor for initializing JFrame components
	public LogicClass() {
		// Providing Title

		lb = new JLabel("Enter Name:");
		lb.setBounds(20, 20, 100, 20);
		tf = new JTextField(20);
		tf.setBounds(100, 20, 200, 20);
		tf.setToolTipText("Please Enter Name Of Country Which You Want To Find");

		btnSearch = new JButton("Search");
		btnSearch.setBounds(350, 20, 100, 20);
		btnSearch.addActionListener(this);
		btnSearch.setToolTipText("Please Enter Name Which You Want To Search");

		table = new JTable();
		table.setBounds(30, 40, 200, 300);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLayout(null);

		// Add components to the JFrame
		add(lb);
		add(tf);
		add(btnSearch);

		btnInsert = new JButton("Insert");
		btnInsert.setBounds(20, 250, 140, 20);
		btnInsert.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(190, 250, 100, 20);
		btnUpdate.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(370, 90,100, 20);
		btnDelete.setToolTipText("For Deletion You Have To Enter Name");
		btnDelete.addActionListener(this);

		lb5 = new JLabel("Insert Data:");
		lb5.setBounds(20, 60, 100, 20);

		lb1 = new JLabel("Name:");
		lb1.setBounds(20, 90, 100, 20);
		lb1.setToolTipText("enter name here");
		
		tf1 = new JTextField(20);
		tf1.setToolTipText("Please enter country name here");
		tf1.setBounds(100, 90, 200, 20);
		


		lb2 = new JLabel("Country Code:");
		lb2.setBounds(20, 120, 100, 20);
		tf2 = new JTextField(20);
		tf2.setToolTipText("Please enter country code here");
		tf2.setBounds(100, 120, 200, 20);

		lb3 = new JLabel("District:");
		lb3.setBounds(20, 150, 100, 20);
		tf3 = new JTextField(20);
		tf3.setToolTipText("Please enter district here");
		tf3.setBounds(100, 150, 200, 20);

		lb4 = new JLabel("Population:");
		lb4.setBounds(20, 180, 100, 20);
		tf4 = new JTextField(20);
		tf4.setToolTipText("Please enter population here");
		tf4.setBounds(100, 180, 200, 20);

		lb5 = new JLabel("Id:");
		lb5.setBounds(20, 210, 100, 20);
		tf5 = new JTextField(20);
		tf5.setToolTipText("Please enter id here");
		tf5.setBounds(100, 210, 200, 20);

		// Add components to the JFrame
		add(lb1);
		add(tf1);
		add(lb5);
		add(btnSearch);
		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		add(lb4);
		add(tf4);
		add(lb5);
		add(tf5);
		add(btnInsert);
		add(btnUpdate);
		add(btnDelete);
		setVisible(true);

		tf1.setEditable(true);
		List<City> citylist = dao.loadCityName();
		cityTable.setCities(citylist);
		setLayout(new BorderLayout(4, 4));
		add(scrollTable(cityTable), BorderLayout.SOUTH);
		setVisible(true);
		// Set TextField Editable False
		tf.setEditable(true);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		String action = evt.getActionCommand();
		if (action.equals("Insert")) {
			addOperation();
		} else if (action.equals("Update")) {
			updateOperation();
		} else if (action.equals("Delete")) {
			deleteOperation();
		} else if (action.equals("Search")) {
			search();
		}
	}

	private void addOperation() {
		Connection conn = (Connection) ConnectionManager.connectivity();
		try {
				String sql = "INSERT INTO City (id,name,countrycode,district,population) " + "Values ('" + tf5.getText()
					+ "'," + "'" + tf1.getText() + "'," + "'" + tf2.getText() + "'," + "'" + tf3.getText() + "'," + "'"
					+ tf4.getText() + "')";
					Statement st = conn.createStatement();
					st.execute(sql);
			JOptionPane.showMessageDialog(null, "Record Added Succesfully.", "Record Added",
					JOptionPane.INFORMATION_MESSAGE);
			clearControls();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Required Field Is Missing","All Fields Are Maditary",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void updateOperation() {
		Connection conn = (Connection) ConnectionManager.connectivity();
		try {
			String sql = "Update City " +

					"SET name= '" + tf1.getText() + "'," +

					"countrycode = '" + tf2.getText() + "'," +

					"district = '" + tf3.getText() + "'," +

					"population = '" + tf4.getText() + "'" +

					"Where id= '" + tf5.getText() + "'";

			Statement st = conn.createStatement();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Record Update Succesfully.", "Record Updated",
					JOptionPane.INFORMATION_MESSAGE);
			clearControls();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteOperation() {
		Connection conn = (Connection) ConnectionManager.connectivity();
		int ans = JOptionPane.showConfirmDialog(null,

				"Are you sure to delete the Record ?", "Delete Record",

				JOptionPane.YES_NO_OPTION);

		if (ans == JOptionPane.YES_OPTION) {
			try {
				String sql = "Delete FROM City where name = '" + tf1.getText() + "'";

				Statement st = conn.createStatement();

				st.execute(sql);
				System.out.println("record deleted successfully");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(null, "Record Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Operation Canceled", "Cancel", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void search() {
		String str = tf.getText();
		try {
			Connection conn = (Connection) ConnectionManager.connectivity();
			PreparedStatement pstmt = conn.prepareStatement("select * from city where name=?");
			pstmt.setString(1, str);

			// Executing Query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Sets Records in TextFields.
				List<City> list = dao.findByName(tf.getText());
				System.out.println(list);
				cityTable.setCities(list);
			} else {
				JOptionPane.showMessageDialog(null, "The Name Which You Want To Search Is Not Present",
						"Operation Canceled", JOptionPane.INFORMATION_MESSAGE);
			}
			// Create Exception Handler
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private void clearControls() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
	}

	public JScrollPane scrollTable(AbstractTableModel model) {
		JTable jtable = new JTable(model);
		JScrollPane jscrollPane = new JScrollPane(jtable);
		return jscrollPane;
	}

}
