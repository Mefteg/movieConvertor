package tom.movieconvertor.ui;

import java.awt.Cursor;
import java.io.File;

import javax.swing.SwingWorker;

import tom.movieconvertor.core.Convertor;
import tom.movieconvertor.core.ConvertorProgress;
import tom.movieconvertor.main.Main;

public class Task extends SwingWorker<Void, Void> {

	private final static String TAG = "Task";

	ViewMain m_view;
	File m_file;

	public Task(ViewMain _view) {
		// TODO Auto-generated constructor stub
		super();
		m_view = _view;
	}

	@Override
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		m_view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		m_view.m_chooser.setControlButtonsAreShown(false);

		if (m_file != null) {
			Convertor m_convertor = new Convertor(m_view, m_file);
			m_convertor.convert();
		}

		return null;
	}
	
	@Override
	public void done() {
		super.done();
		
		m_view.m_chooser.rescanCurrentDirectory();
		m_view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		m_view.m_chooser.setControlButtonsAreShown(true);
	}

	public void setFile(File _file) {
		m_file = _file;
	}
}
