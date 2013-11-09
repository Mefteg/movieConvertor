package tom.movieconvertor.core;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoInfo;

import java.io.File;

import tom.movieconvertor.ui.ViewMain;

public class Convertor {
	
	private final static String TAG = "Convertor";
	
	ViewMain m_view;

	private File m_in;
	private File m_out;
	
	ConvertorProgress m_progress;

	public Convertor(ViewMain _view, File _in) {
		// TODO Auto-generated constructor stub
		m_in = _in;
		String newName = "tv_" + m_in.getName();
		m_out = new File(m_in.getParent() + "/" + newName);
		
		m_progress = new ConvertorProgress(m_view);
	}

	public void convert() {
		Encoder encoder = new Encoder();

		try {
			MultimediaInfo infos = encoder.getInfo(m_in);

			VideoInfo videoInfo = infos.getVideo();

			AudioAttributes audioAttr = new AudioAttributes();
			audioAttr.setCodec("libmp3lame");
			audioAttr.setBitRate(new Integer(128000));
			audioAttr.setChannels(new Integer(2));
			audioAttr.setSamplingRate(new Integer(44100));

			VideoAttributes videoAttr = new VideoAttributes();
			videoAttr.setCodec("mpeg4");
			videoAttr.setBitRate(new Integer(8000000));
			videoAttr.setFrameRate(new Integer((int) videoInfo.getFrameRate()));

			EncodingAttributes attr = new EncodingAttributes();
			attr.setFormat("avi");
			attr.setAudioAttributes(audioAttr);
			attr.setVideoAttributes(videoAttr);
			
			encoder.encode(m_in, m_out, attr, m_progress);
		} catch (InputFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ConvertorProgress getProgressBar() {
		return m_progress;
	}
}
