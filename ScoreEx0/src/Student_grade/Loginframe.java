package Student_grade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Loginframe extends JFrame {
	
	JFrame frame;
	private JTextField textId, textPw;
	
	public Loginframe() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.white);
		frame.setBounds(100, 100, 578, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성적 관리 프로그램");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 34));
		lblNewLabel.setBounds(12, 10, 266, 66);
		frame.getContentPane().add(lblNewLabel);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 34));
		textId.setColumns(10);
		textId.setBounds(136, 194, 318, 55);
		frame.getContentPane().add(textId);
		
		textPw = new JTextField();
		textPw.setFont(new Font("굴림", Font.PLAIN, 34));
		textPw.setColumns(10);
		textPw.setBounds(136, 261, 318, 55);
		frame.getContentPane().add(textPw);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 44));
		lblId.setBounds(12, 194, 107, 55);
		frame.getContentPane().add(lblId);
		
		JLabel lblpw = new JLabel("PW");
		lblpw.setFont(new Font("굴림", Font.PLAIN, 44));
		lblpw.setBounds(12, 261, 78, 55);
		frame.getContentPane().add(lblpw);
		
		JButton btnstudentjoin = new JButton("회원가입");
		btnstudentjoin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				StudentInsertFrame insertFrame = new StudentInsertFrame();
				insertFrame.setVisible(true);
			}
		});
		
		btnstudentjoin.setFont(new Font("굴림", Font.PLAIN, 24));
		btnstudentjoin.setBounds(193, 395, 211, 46);
		btnstudentjoin.setBackground(new Color(30,144,255));
		btnstudentjoin.setBackground(Color.black);
		frame.getContentPane().add(btnstudentjoin);
		
		JButton btnStudentLogin = new JButton("학생용 로그인");
		btnStudentLogin.setFont(new Font("굴림", Font.PLAIN, 14));
		btnStudentLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String id1 = textId.getText();
				String pw1 = textPw.getText();
				
				if(id1.isBlank() || pw1.isBlank()) {
					JOptionPane.showConfirmDialog(frame, "ID와 PW를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return;	
				}
				
				String id = textId.getText();
				String pw = textPw.getText();
				
				StudentDAO dao = StudentDAOImple.getInstance();
				boolean loggIn = dao.login(id, pw);
				
				if(loggIn) {
					StudentGradeFrame studentGradeFrame = new StudentGradeFrame();
					studentGradeFrame.frame.setVisible(true);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showConfirmDialog(frame, "아이디 또는 비밀번호가 일치하지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStudentLogin.setBounds(278, 23, 121, 34);
		btnStudentLogin.setBackground(new Color(30,144,255));
		btnStudentLogin.setForeground(Color.black);
		frame.getContentPane().add(btnStudentLogin);
		
		JButton btnTeacherLogin = new JButton("교사용 로그인");
		btnTeacherLogin.setFont(new Font("굴림", Font.PLAIN, 14));
		btnTeacherLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TeacherLoginFrame teacherloginFrame = new TeacherLoginFrame();
				teacherloginFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnTeacherLogin.setBounds(411, 23, 121, 34);
		btnTeacherLogin.setBackground(new Color(30,144,255));
		btnTeacherLogin.setForeground(Color.black);
		
		frame.getContentPane().add(btnTeacherLogin);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
