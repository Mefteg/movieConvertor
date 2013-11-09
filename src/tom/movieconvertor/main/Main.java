package tom.movieconvertor.main;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoInfo;
import it.sauronsoftware.jave.VideoSize;

import java.io.File;

import javax.swing.SwingUtilities;

import tom.movieconvertor.ui.ViewMain;

public class Main {

	private final static String TAG = "Main";

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ViewMain view = new ViewMain();
				view.setVisible(true);
			}
		});
	}

	public static void log(String _tag, String _message) {
		System.out.println(_tag + " - " + _message);
	}
}
