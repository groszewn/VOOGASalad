package authoring_environment.FileHandlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.junit.runners.model.TestClass;

import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.AudioClip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import structures.data.DataSound;
import structures.data.DataSprite;

public class SoundMaker {
	private static ResourceBundle r = ResourceBundle.getBundle("resources/EnvironmentGUIResources");
	public static void load(Stage s, ObservableList<DataSound> sounds){
		
		File selectedFile = FileHelper.choose(s);
		try {	
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(selectedFile);
		  	AudioFileFormat fileType = AudioSystem.getAudioFileFormat(selectedFile);
			
			String name = FileHelper.askName();
			System.out.println("test");
			System.out.println(fileType.getType().toString());
			File outputfile = new File(r.getString("soundsFolder") + name + ".wav");
			
			if (AudioSystem.isFileTypeSupported(fileType.getType(), 
			    audioInputStream)) {
				System.out.println("hello");
				AudioSystem.write(audioInputStream, fileType.getType(), outputfile);
			}
			DataSound sound = new DataSound(name, outputfile.getName());
			sounds.add(sound);

		} catch (Exception e) {
			
			
		}
	
	}
	
	
}
