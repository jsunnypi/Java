package Student_grade;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class StudentGradeFrame {

	JFrame frame;
	private JTextArea txtAreaLog_1;
	private static GradeDAO dao;
	private Component currentComponent;
	
	private JTable table;
	private String[] colNames = {"학번", "학년", "이름", "국어", "수학", "영어", "평균", "석차"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	
	public StudentGradeFrame() {
		try {
			dao = GradeDAOImple.getInstance();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnselectstudentid = new JButton("학번 검색");
		btnselectstudentid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String TxtAreaLog_1 = txtAreaLog_1.getText();
				
				if(TxtAreaLog_1.isBlank() || TxtAreaLog_1.equals("학번 입력")) {
					JOptionPane.showMessageDialog(frame, "학번을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String studentid = txtAreaLog_1.getText();
				
				int Studentid;
				try {
					Studentid = Integer.parseInt(studentid);
				} catch(NumberFormatException e1) {
					return;
				}
				ArrayList<GradeVO> list = dao.select();
				
				if(list.isEmpty()) {
					JOptionPane.showInternalMessageDialog(frame, "학생 정보가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					tableModel.setRowCount(0);
				} else {
					System.out.println("학생 정보가 있습니다.");
					selectGradeTable(Studentid);
				}
			}
		});
		btnselectstudentid.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnselectstudentid.setBounds(96, 71, 110, 34);
		frame.getContentPane().add(btnselectstudentid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302, 10, 490, 312);
		frame.getContentPane().add(scrollPane);
		
		tableModel = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		
		scrollPane.setViewportView(table);
		
		JLabel lblstudentid_1 = new JLabel("학번 검색");
		lblstudentid_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid_1.setBounds(12, 10, 76, 34);
		frame.getContentPane().add(lblstudentid_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 10, 180, 34);
		frame.getContentPane().add(scrollPane_1);
		
		txtAreaLog_1 = new JTextArea();
		scrollPane_1.setViewportView(txtAreaLog_1);
		txtAreaLog_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtAreaLog_1.setText("");
			}
		});
		
		txtAreaLog_1.setFont(new Font("굴림", Font.PLAIN, 17));
		txtAreaLog_1.setColumns(5);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Loginframe loginFrame = new Loginframe();
				loginFrame.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnLogout.setBounds(685, 336, 107, 23);
		frame.getContentPane().add(btnLogout);
		
		
	}

	protected void selectGradeTable(int studentid) {
		ArrayList<GradeVO> list = dao.select();
		
		list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());
		
		int studentRank = -1;
		
		int rank = 1;
		for(GradeVO vo : list) {
			vo.setRank(rank++);
			if(vo.getStudentId() == studentid) {
				studentRank = vo.getRank();
				break;
			}
		}
		
		if(studentRank != -1) {
			tableModel.setRowCount(0);
			for(GradeVO vo : list) {
				if(vo.getStudentId() == studentid) {
					records[0] = vo.getStudentId();
					records[1] = vo.getClassYear();
					records[2] = vo.getStudentName();
					records[3] = vo.getKor();
					records[4] = vo.getEng();
					records[5] = vo.getMath();
					records[6] = vo.getAvg();
					records[7] = vo.getRank();
					tableModel.addRow(records);			
				}
			}
		} else {
			tableModel.setRowCount(0);
			JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void selectAllGradeTable() {
		ArrayList<GradeVO> list = dao.select();
		
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
			tableModel.setRowCount(0);
		} else {
			System.out.println("학생 정보가 있습니다.");
			
			list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());
		
			int rank = 1;
			for(GradeVO vo : list) {
				vo.setRank(rank++);
			}
			
			tableModel.setRowCount(0);
			
			for(int i=0; i<list.size(); i++) {
				GradeVO vo = list.get(i);
				
				records[0] = vo.getStudentId();
				records[1] = vo.getClassYear();
				records[2] = vo.getStudentName();
				records[3] = vo.getKor();
				records[4] = vo.getEng();
				records[5] = vo.getMath();
				records[6] = vo.getAvg();
				records[7] = vo.getRank(); 
				tableModel.addRow(records);
			}
		}
	}
	
}




























