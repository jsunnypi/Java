package Student_grade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class StudentInsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw, txtName, txtClassyear, txtEmail;
	private JFrame frame;
	private DefaultTableModel tableModel;
	
	private StudentDAO dao;
	private JButton btnFindid;
	
	public StudentInsertFrame() {
		frame = this;
		dao = StudentDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(125, 10, 144, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(125, 53, 144, 33);
		contentPane.add(txtPw);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(125, 96, 144, 33);
		contentPane.add(txtName);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 10, 101, 24);
		contentPane.add(lblId);

		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(12, 54, 101, 24);
		contentPane.add(lblPw);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 98, 101, 24);
		contentPane.add(lblName);
		
		JButton btnInsert = new JButton("회원 등록");
		btnInsert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				insertStudent();
			}
		});
		btnInsert.setBounds(12, 263, 114, 38);
		contentPane.add(btnInsert);
		
		JLabel lblClassyear = new JLabel("학년");
		lblClassyear.setBounds(12, 143, 101, 24);
		contentPane.add(lblClassyear);
		
		txtClassyear = new JTextField();
		txtClassyear.setColumns(10);
		txtClassyear.setBounds(125, 139, 144, 33);
		contentPane.add(txtClassyear);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 187, 101, 24);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 182, 144, 33);
		contentPane.add(txtEmail);
		
		btnFindid = new JButton("ID 찾기");
		btnFindid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentIdFindFrame studentIdFindFrame = new StudentIdFindFrame();
				studentIdFindFrame.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		
		btnFindid.setBounds(155, 263, 114, 38);
		contentPane.add(btnFindid);		
	}
	public void insertStudent() {
		String id1 = txtId.getText();
		String pw1 = txtPw.getText();
		String name1 = txtName.getText();
		String classyear1 = txtClassyear.getText();
		String email1 = txtEmail.getText();
		
		if(id1.isBlank() || pw1.isBlank() || name1.isBlank() || classyear1.isBlank() || email1.isBlank()) {
			JOptionPane.showMessageDialog(frame, "모든 입력 필드를 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			String id = txtId.getText();
			String pw = txtPw.getText();
			String name = txtName.getText();
			int classyear = Integer.parseInt(txtClassyear.getText());
			String email = txtEmail.getText();
			
			StudentVO vo = new StudentVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setClassyear(classyear);
			vo.setEmail(email);
			
			int result = dao.insert(vo);
			
			if(result == 1) {
				JOptionPane.showInternalMessageDialog(frame, "회원 등록이 완료되었습니다.");
			}
			else {
				JOptionPane.showMessageDialog(frame, "id가 중복입니다. 다시 시도하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "학년을 제외한 모든 필드를 문자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
}

















