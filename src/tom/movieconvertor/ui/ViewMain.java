package tom.movieconvertor.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileFilter;

import tom.movieconvertor.core.Convertor;
import tom.movieconvertor.main.Main;

public class ViewMain extends JFrame implements ActionListener,
		PropertyChangeListener {

	private final static String TAG = "ViewMain";
	
	ViewMain m_me;

	JFileChooser m_chooser;

	Task m_task;
	Convertor m_convertor;

	public ViewMain() {
		super();
		// TODO Auto-generated constructor stub
		
		m_me = this;

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"assets/iconMovieConvertor.png"));
		build();
	}

	private void build() {
		setTitle("Convertisseur vidéo TV Philips");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel lblSelect = new JLabel("Sélectionnez la vidéo à convertir");
		lblSelect.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(lblSelect);

		m_chooser = new JFileChooser() {
			@Override
			public void approveSelection() {
				super.approveSelection();

				File file = m_chooser.getSelectedFile();

				m_task = new Task(m_me);
				//m_task.addPropertyChangeListener(m_me);
				m_task.setFile(file);
				m_task.execute();
			}
		};
		m_chooser.setApproveButtonText("Convertir");
		m_chooser.addActionListener(this);
		m_chooser.addChoosableFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "*.avi, *.mp4";
			}
			
			@Override
			public boolean accept(File f) {
				String name = f.getName();
				// TODO Auto-generated method stub
				if (name.endsWith(".avi") ||
						name.endsWith(".AVI") ||
						name.endsWith(".mp4") ||
						name.endsWith(".MP4") ||
						f.isDirectory()) {
					return true;
				} else {
					return false;
				}
			}
		});
		panel.add(m_chooser);

		setContentPane(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		Main.log(TAG, "CHANGE");
	}
}
