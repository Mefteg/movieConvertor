package tom.movieconvertor.core;

import it.sauronsoftware.jave.EncoderProgressListener;
import it.sauronsoftware.jave.MultimediaInfo;
import tom.movieconvertor.main.Main;
import tom.movieconvertor.ui.ViewMain;

public class ConvertorProgress implements EncoderProgressListener {
	
	private final static String TAG = "ConvertorProgress";
	
	ViewMain m_view;
	protected int m_progress;
	
	public ConvertorProgress(ViewMain _view) {
		// TODO Auto-generated constructor stub
		m_view = _view;
	}

	@Override
	public void message(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void progress(int arg0) {
		// TODO Auto-generated method stub
		m_progress = arg0 / 10;
		//Main.log(TAG, "progress : " + m_progress + "%");
	}

	@Override
	public void sourceInfo(MultimediaInfo arg0) {
		// TODO Auto-generated method stub

	}
	
	public int getProgess() {
		return m_progress;
	}
}
