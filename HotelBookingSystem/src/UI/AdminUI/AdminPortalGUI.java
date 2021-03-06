package UI.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mongodb.DBObject;
import com.toedter.calendar.JDateChooser;

import Control.GuestDB;
import Model.Details;
import Model.Guest.GuestBooking;
import Model.Guest.GuestInfo;

@SuppressWarnings("serial")
public class AdminPortalGUI extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel firstnamelbl;
	private JTextField firstNametxt;
	private JTextField phonetxt;
	private JTextField lastNametxt;
	private JTextField emailtxt;
	private JTextField searchtxt;
	private JTextField nationalitytxt;
	private JTextField purposeOfStaytxt;
	private JTextField addresstxt;
	private JTextField roomNumbertxt;
	private JDateChooser dateCheckIn;
	private JDateChooser dateCheckOut;
	@SuppressWarnings("rawtypes")
	private JComboBox searchFilterBox;
	private JButton searchBtn;
	private JLabel searchCriterialbl;
	private JButton editbtn;
	private JButton deletebtn;
	private JButton newGuestbtn;
	private JLabel guestInfolbl;
	private JLabel lastNamelbl;
	private JLabel phonelbl;
	private JLabel emaillbl;
	private JLabel nationalitylbl;
	private JLabel purpose_Of_Staylbl;
	private JLabel addresslbl;
	private JLabel guestBookinglbl;
	private JLabel numOfPersonslbl;
	private JSpinner numOfPersonspinner;
	@SuppressWarnings("rawtypes")
	private JComboBox roomTypeBox;
	private JLabel roomNumberlbl;
	private JLabel checkInlbl;
	private JLabel dateCheckOutlbl;
	private JCheckBox lunchDinnerChkBox;
	private JLabel accomadationlbl;
	private JTextArea additionaltxt;
	private JButton confirmbtn;
	private JTable queryOutputTbl;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
//		Admin_portalframe = new JFrame();
//		Admin_portalframe.setTitle("Admin Portal");
//		Admin_portalframe.setBounds(100, 100, 684, 516);
//		Admin_portalframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 68, 475, 104);
		contentPane.add(scrollPane);
		
		queryOutputTbl = new JTable();
		scrollPane.setViewportView(queryOutputTbl);
		
		searchCriterialbl = new JLabel("Search Criteria");
		searchCriterialbl.setBounds(34, 6, 605, 16);
		searchCriterialbl.setHorizontalTextPosition(SwingConstants.CENTER);
		searchCriterialbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(searchCriterialbl);
		
		firstnamelbl = new JLabel("First Name");
		firstnamelbl.setBounds(6, 212, 77, 16);
		contentPane.add(firstnamelbl);
		
		firstNametxt = new JTextField();
		firstNametxt.setBounds(83, 207, 130, 26);
		firstNametxt.setColumns(10);
		contentPane.add(firstNametxt);
		
		phonelbl = new JLabel("Phone");
		phonelbl.setBounds(225, 212, 61, 16);
		contentPane.add(phonelbl);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(271, 207, 130, 26);
		phonetxt.setColumns(10);
		contentPane.add(phonetxt);
		
		lastNamelbl = new JLabel("Last Name");
		lastNamelbl.setBounds(6, 241, 77, 16);
		contentPane.add(lastNamelbl);
		
		lastNametxt = new JTextField();
		lastNametxt.setBounds(83, 236, 130, 26);
		lastNametxt.setColumns(10);
		contentPane.add(lastNametxt);
		
		emaillbl = new JLabel("Email");
		emaillbl.setBounds(225, 240, 61, 16);
		contentPane.add(emaillbl);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(271, 235, 130, 26);
		emailtxt.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(emailtxt);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(6, 34, 181, 26);
		contentPane.add(searchtxt);
		searchtxt.setColumns(10);
		
		searchFilterBox = new JComboBox();
		searchFilterBox.setBounds(199, 35, 147, 27);
		contentPane.add(searchFilterBox);
		searchFilterBox.addItem("None");
		for(int i = 0; i < Details.COLUMNS.length; i++) {
			searchFilterBox.addItem(Details.COLUMNS[i]);
		}

		newGuestbtn = new JButton("New Guest");
		newGuestbtn.addActionListener(this);
//		newGuestbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				db.insertGuest(guest(), booking());
//			}
//		});
		newGuestbtn.setBounds(493, 143, 117, 29);
		contentPane.add(newGuestbtn);
		
		nationalitylbl = new JLabel("Nationality");
		nationalitylbl.setBounds(413, 212, 77, 16);
		contentPane.add(nationalitylbl);
		
		purpose_Of_Staylbl = new JLabel("Purpose Of Stay");
		purpose_Of_Staylbl.setBounds(413, 241, 99, 16);
		contentPane.add(purpose_Of_Staylbl);
		
		nationalitytxt = new JTextField();
		nationalitytxt.setBounds(524, 207, 130, 26);
		contentPane.add(nationalitytxt);
		nationalitytxt.setColumns(10);
		
		purposeOfStaytxt = new JTextField();
		purposeOfStaytxt.setBounds(524, 236, 130, 26);
		contentPane.add(purposeOfStaytxt);
		purposeOfStaytxt.setColumns(10);
		
		guestInfolbl = new JLabel("Guest Info");
		guestInfolbl.setBounds(8, 186, 86, 16);
		contentPane.add(guestInfolbl);
		
		addresslbl = new JLabel("Address");
		addresslbl.setBounds(6, 272, 61, 16);
		contentPane.add(addresslbl);
		
		addresstxt = new JTextField();
		addresstxt.setBounds(83, 267, 318, 26);
		contentPane.add(addresstxt);
		addresstxt.setColumns(10);
		
		guestBookinglbl = new JLabel("Guest Booking Information");
		guestBookinglbl.setBounds(6, 300, 181, 16);
		contentPane.add(guestBookinglbl);
		
		numOfPersonslbl = new JLabel("Number Of Persons");
		numOfPersonslbl.setBounds(6, 328, 130, 16);
		contentPane.add(numOfPersonslbl);
		
		numOfPersonspinner = new JSpinner();
		numOfPersonspinner.setBounds(140, 323, 47, 26);
		contentPane.add(numOfPersonspinner);
		
		JLabel roomTypelbl = new JLabel("Room Type");
		roomTypelbl.setBounds(199, 328, 77, 16);
		contentPane.add(roomTypelbl);
		
		roomTypeBox = new JComboBox();
		roomTypeBox.setBounds(271, 324, 130, 27);
		contentPane.add(roomTypeBox);
		for(int i = 0; i < Details.ROOM_TYPE.length; i++) {
			roomTypeBox.addItem(Details.ROOM_TYPE[i]);
		}
		
		roomNumberlbl = new JLabel("Room Number");
		roomNumberlbl.setBounds(413, 328, 99, 16);
		contentPane.add(roomNumberlbl);
		
		roomNumbertxt = new JTextField();
		roomNumbertxt.setBounds(524, 323, 130, 26);
		contentPane.add(roomNumbertxt);
		roomNumbertxt.setColumns(10);
		
		checkInlbl = new JLabel("Check In Date");
		checkInlbl.setBounds(6, 361, 99, 16);
		contentPane.add(checkInlbl);
		
		dateCheckIn = new JDateChooser();
		dateCheckIn.setBounds(106, 356, 149, 26);
		contentPane.add(dateCheckIn);
		
		dateCheckOutlbl = new JLabel("Check Out Date");
		dateCheckOutlbl.setBounds(271, 361, 109, 16);
		contentPane.add(dateCheckOutlbl);
		
		dateCheckOut = new JDateChooser();
		dateCheckOut.setBounds(392, 356, 149, 26);
		contentPane.add(dateCheckOut);
		
		lunchDinnerChkBox = new JCheckBox("Lunch & Dinner");
		lunchDinnerChkBox.setBounds(548, 357, 130, 23);
		contentPane.add(lunchDinnerChkBox);
		lunchDinnerChkBox.addActionListener(this);
		
		accomadationlbl = new JLabel("Additional Accomadation");
		accomadationlbl.setBounds(6, 389, 167, 16);
		contentPane.add(accomadationlbl);
		
		additionaltxt = new JTextArea();
		additionaltxt.setBounds(6, 417, 358, 64);
		contentPane.add(additionaltxt);
		
		deletebtn = new JButton("Delete Guest");
		deletebtn.addActionListener(this);
//		deletebtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				db.deleteRecord(getSelectedrowPhone().toString());
//			}
//		});
		deletebtn.setBounds(493, 113, 117, 29);
		contentPane.add(deletebtn);
		
		confirmbtn = new JButton("Confirm");
		confirmbtn.addActionListener(this);
//		confirmbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(checkDate()) {
//					db.deleteRecord(phonetxt.getText());
//					db.insertGuest(guest(), booking());
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Please mention Check In and Check Out dates");
//				}
//
//			}
//		});
		confirmbtn.setBounds(422, 417, 217, 38);
		contentPane.add(confirmbtn);
		
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
//		searchBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				searchandAddtoTable();
//			}
//		});
		searchBtn.setBounds(358, 34, 117, 29);
		contentPane.add(searchBtn);
		
		editbtn = new JButton("Edit Info");
		editbtn.addActionListener(this);
//		editbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				DBObject[] jsonrow = db.searchGuest(getSelectedrowPhone());
//				System.out.println("jsonrow" + jsonrow );
//				printInfo(jsonrow);				
//			}
//		});
		editbtn.setBounds(493, 83, 117, 29);
		contentPane.add(editbtn);
	}
	
	public AdminPortalGUI() {
		setTitle("Admin Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		initialize();
	}
	
	GuestInfo guestInfo;
	GuestBooking guestBooking;
	GuestDB db = new GuestDB();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// New Guest Button:
		if(e.getSource() == newGuestbtn) {
			if(guest().validInfo() == true || booking().validBooking() == true) {
				db.insertGuest(guest(), booking());
			}
			else {
				JOptionPane.showMessageDialog(null, "You must fill in the required fields in order to insert a new hotel guest.");
			}
		}
		// Delete Guest Button:
		if(e.getSource() == deletebtn) {
			Object rowSelect = getSelectedrowPhone();
			if(rowSelect != null) {
				db.deleteRecord(rowSelect.toString());
			}
			else {
				JOptionPane.showMessageDialog(null, "You need to search & select a hotel guest in order to delete them from the database.");
			}
		}
		// Confirm Button:
		if(e.getSource() == confirmbtn) {
			if(guest().validInfo() == true || booking().validBooking() == true) {
				db.deleteRecord(phonetxt.getText());
				db.insertGuest(guest(), booking());
			}
			else {
				JOptionPane.showMessageDialog(null, "You must fill in the required fields in order to update the details of an existing hotel guest.");
			}
		}
		// Search Button:
		if(e.getSource() == searchBtn) {
			searchandAddtoTable();
		}
		// Edit Button:
		if(e.getSource() == editbtn) {
			Object rowSelect = getSelectedrowPhone();
			if(rowSelect != null) {
				DBObject[] jsonrow = db.searchGuest(getSelectedrowPhone());
				System.out.println("jsonrow" + jsonrow );
				printInfo(jsonrow);
			}
			else {
				JOptionPane.showMessageDialog(null, "You need to search & select a hotel guest in order to update their information in the database.");
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPortalGUI frame = new AdminPortalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void searchandAddtoTable() {
		
		DefaultTableModel model = new DefaultTableModel();
		Object[][] rows = db.getBasicGuestInfo();
		
		for (int i = 0; i< Details.COLUMNS.length; i ++)
		{
			model.addColumn(Details.COLUMNS[i]);

		}
		int searchIndex = -1;
		String searchObject = searchtxt.getText().toString();
		
		if(searchObject != null || searchObject != "")
		{
			if(searchFilterBox.getSelectedItem() == "firstname") {
				searchIndex = 0;
			}else if (searchFilterBox.getSelectedItem() == "lastname") {
				searchIndex = 1;
				
			}else if (searchFilterBox.getSelectedItem() == "email") {
				searchIndex = 2;
				
			}else if (searchFilterBox.getSelectedItem() == "phone") {
				searchIndex = 3;	
			}else {
				searchIndex =-1;
			}
		}	
		for(int i=0; i < rows.length;i++)
		{
			if(searchIndex == -1)
			{
				model.addRow(rows[i]);	
			}
			else if (rows[i][searchIndex].equals(searchObject))
			{
				model.addRow(rows[i]);
			}
		}			
		queryOutputTbl.setModel(model);
	}

	public void printInfo(DBObject[] row) {
		
		firstNametxt.setText(row[0].get("firstName").toString());
		lastNametxt.setText(row[0].get("lastName").toString());
		emailtxt.setText(row[0].get("email").toString());
		phonetxt.setText(row[0].get("phone").toString());
		nationalitytxt.setText(row[0].get("nationality").toString());
		addresstxt.setText(row[0].get("address").toString());
		purposeOfStaytxt.setText(row[0].get("purposeOfStay").toString());
		numOfPersonspinner.setValue(row[1].get("numPersons"));
		roomTypeBox.setSelectedItem(row[1].get("roomType"));
		roomNumbertxt.setText(row[1].get("roomNumber").toString());
		if(row[1].get("lunchAndDinner").toString() == "true")
			lunchDinnerChkBox.setSelected(true);
		else
			lunchDinnerChkBox.setSelected(false);
		additionaltxt.setText(row[1].get("addAccomodations").toString());
		
		try {
			Date checkIn = retrieveDate(row[1].get("checkInDate").toString());
			Date checkOut = retrieveDate(row[1].get("checkOutDate").toString());
			dateCheckIn.setDate(checkIn);
			dateCheckOut.setDate(checkOut);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Date retrieveDate(String date) throws ParseException {
		String[] strDate = date.split(" ");
		String rawDate = strDate[2] + " " + strDate[1] + " " + strDate[5];
		Date simpleDate = new SimpleDateFormat("dd MMM yyyy").parse(rawDate);
		return simpleDate;
	}
	
	private GuestInfo guest() {
		String firstName = firstNametxt.getText().toString();
		String lastName = lastNametxt.getText().toString();
		String address = addresstxt.getText().toString();
		String email = emailtxt.getText().toString();
		String phone = phonetxt.getText().toString();
		String nationality = nationalitytxt.getText().toString();
		String purposeOfStay = purposeOfStaytxt.getText().toString();
		GuestInfo guestInfo = new GuestInfo(firstName,lastName,address,email,phone,nationality,purposeOfStay);
		System.out.print(guestInfo);
		return guestInfo;
	}
	
	private GuestBooking booking() {
		int numPersons = Integer.parseInt(numOfPersonspinner.getValue().toString());
		String roomType = roomTypeBox.getSelectedItem().toString();
		int roomNumber;
		try {
			roomNumber = Integer.parseInt(roomNumbertxt.getText().toString());
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			roomNumber = 0;
		}
		LocalDate checkInDate = formatDate(dateCheckIn);
		LocalDate checkOutDate = formatDate(dateCheckOut);
		boolean lunchAndDinner;
		if(lunchDinnerChkBox.isSelected()) {
			lunchAndDinner = true;
		}
		else {
			lunchAndDinner = false;
		}
		String addAccomodations = additionaltxt.getText().toString();
		GuestBooking guestBooking = new GuestBooking(numPersons,roomType,roomNumber, checkInDate,checkOutDate,lunchAndDinner,addAccomodations);
		return guestBooking;
	}
	
	@SuppressWarnings("deprecation")
	private LocalDate formatDate(JDateChooser date) {
		LocalDate retDate;
		try {
			retDate = LocalDate.of(date.getDate().getYear()+1900,date.getDate().getMonth()+1,date.getDate().getDate());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			retDate = LocalDate.now();
		}
		return retDate;
	}
	
	private Object getSelectedrowPhone() {
		Object searchPhoneString = null;
		try {
			int selectedIndex = queryOutputTbl.getSelectedRow();
			searchPhoneString = queryOutputTbl.getModel().getValueAt(selectedIndex, Details.PHONE_INDEX);
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		}
		return searchPhoneString;
	}
}
