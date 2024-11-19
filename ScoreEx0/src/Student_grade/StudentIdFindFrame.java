package Student_grade;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// TEACHERIDFIND FRAME 을 수정해서 입력
public class StudentIdFindFrame {

	JFrame frame;
	private JTextField txtId, txtPw, txtEmail, txtName, txtClassyear;
	private JTextArea txtAreaInfo;
	
	private static StudentDAO dao;
	
	public StudentIdFindFrame() {
		try {
			dao = StudentDAOImple.getInstance();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 355, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 20));
		lblId.setBounds(12, 8, 25, 30);
		frame.getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPw.setBounds(12, 48, 35, 24);
		frame.getContentPane().add(lblPw);
		
		Font txtFont = new Font("굴림", Font.PLAIN, 34);
		int txtWidth = 286;
		int txtHeight = 55;
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 18));
		txtId.setBounds(49, 6, 200, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPw.setBounds(49, 42, 200, 30);
		frame.getContentPane().add(txtPw);
		txtPw.setColumns(10);
		
		Font btnFont = new Font("굴림", Font.PLAIN, 24);
		
		JButton btnSearch = new JButton("ID 검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectstudentId();
			}
		});
		
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSearch.setBounds(12, 209, 88, 30);
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("ID 수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updatestudentId();
			}			
		});
		
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 18));
		btnUpdate.setBounds(100, 209, 94, 30);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("ID 삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deletestudentId();
			}
		});
		
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 18));
		btnDelete.setBounds(196, 209, 88, 30);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 249, 305, 142);
		frame.getContentPane().add(scrollPane);
		
		txtAreaInfo = new JTextArea();
		scrollPane.setViewportView(txtAreaInfo);
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
	
		txtEmail = new JTextField();
		txtEmail.setBounds(16, 167, 178, 32);
		frame.getContentPane().add(txtEmail);
		txtEmail.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {
					txtEmail.setText("");
				}	
		});
		
		txtEmail.setText("EMAIL 입력");
		txtEmail.setFont(new Font("굴림", Font.PLAIN, 17));
		txtEmail.setColumns(5);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(6, 82, 41, 24);
		frame.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(49, 79, 200, 30);
		frame.getContentPane().add(txtName);
	
		JLabel lblName_1 = new JLabel("과목");
		lblName_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName_1.setBounds(6, 116, 41, 24);
		frame.getContentPane().add(lblName_1);
		
		txtClassyear = new JTextField();
		txtClassyear.setFont(new Font("굴림", Font.PLAIN, 18));
		txtClassyear.setColumns(10);
		txtClassyear.setBounds(49, 114, 200, 30);
		frame.getContentPane().add(txtClassyear);
		
	}
	
	private void selectstudentId() {
		
		String email2 = txtEmail.getText();
		
		if(email2.isBlank() || email2.equals("EMAIL 입력")) {
			JOptionPane.showMessageDialog(frame, "이메일을 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String email = txtEmail.getText();
		
		StudentVO vo = dao.select(email);
		
		if(vo.getEmail() != null) {
			txtAreaInfo.setText(vo.toString());
		} else {
			txtAreaInfo.setText("");
			JOptionPane.showMessageDialog(frame, "해당 이메일이 존재하지 않습니다", "오류", JOptionPane.ERROR_MESSAGE);
		}	
	}
		
		private void updatestudentId() {
			String id1 = txtId.getText();
			String pw1 = txtPw.getText();
			String name1 = txtName.getText();
			String subject1 = txtClassyear.getText();
			String email1 = txtEmail.getText();
			
			if(id1.isBlank() || pw1.isBlank() || name1.isBlank() || subject1.isBlank() || email1.isBlank()) {
				JOptionPane.showMessageDialog(frame, "모든 입력 필드를 채워주세요", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String id = txtId.getText();
			String pw = txtPw.getText();
			String name = txtName.getText();
			int classyear = Integer.getInteger(txtClassyear.getText());
			String email = txtEmail.getText();
			
			StudentVO vo = new StudentVO(id, pw, name, classyear, email);
			
			int result = dao.update(email, vo);
			
			if(result == 1) {
				JOptionPane.showMessageDialog(frame, "id 정보가 성공적으로 수정되었습니다", "오류", JOptionPane.ERROR_MESSAGE);				
			} else if(result == 0) {
				JOptionPane.showMessageDialog(frame, "학생 정보 수정에 실패했습니다", "오류", JOptionPane.ERROR_MESSAGE);
				
			} else {
				JOptionPane.showInternalMessageDialog(frame, "이메일이 올바르지 않습니다", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		private void deletestudentId() {
			String email2 = txtEmail.getText();
			if(email2.isBlank() || email2.equals("EMAIL 입력")) {
				JOptionPane.showMessageDialog(frame, "이메일을 입력해주세요", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String email = txtEmail.getText();
			
			int result = dao.delete(email);
			if(result == 1) {
				JOptionPane.showMessageDialog(frame, "id 삭제가 완료되었습니다");
			} else if(result == 0 ) {
				JOptionPane.showMessageDialog(frame, "id 삭제에 실패했습니다", "오류", JOptionPane.ERROR_MESSAGE);
				
			} else {
				JOptionPane.showMessageDialog(frame, "Email이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}































