package org.sikuli.api.examples;
import java.net.MalformedURLException;
import java.net.URL;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.audio.DesktopSpeaker;
import org.sikuli.api.audio.Speaker;
import org.sikuli.api.audio.SpeakerPlayable;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.api.visual.Canvas;

public class SpeakerExample {
	
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
	static Canvas canvas = new DesktopCanvas();
	static Speaker speaker = new DesktopSpeaker();
	
	static ScreenSimulator simulator = new ScreenSimulator(){
		public void run(){
			showImage(Images.GoogleSearchPage);
			wait(8);
			close();
		}
	};

	public static void main(String[] args) throws MalformedURLException {
		simulator.start();		

		ScreenRegion s = new DesktopScreenRegion();	
		
		URL clickhere = SpeakerExample.class.getResource("clickhere.wav");
		
		URL imageURL = Images.GoogleSearchButton;                
		Target imageTarget = new ImageTarget(imageURL);
		ScreenRegion r = s.find(imageTarget);		
		mouse.click(r.getCenter());		
		
		canvas.clear().addBox(r);
		canvas.displayWhile(new SpeakerPlayable(clickhere));

		imageURL = Images.GoogleMicrophoneIcon;                
		imageTarget = new ImageTarget(imageURL);    			
		r = s.find(imageTarget);       			
		mouse.rightClick(r.getCenter());

		canvas.clear().addBox(r);
		canvas.displayWhile(new SpeakerPlayable(clickhere));

		imageURL = Images.GoogleSearchFeelingLuckyButton;                
		imageTarget = new ImageTarget(imageURL);    			
		r = s.find(imageTarget);
		mouse.doubleClick(r.getCenter());

		canvas.clear().addBox(r);
		canvas.displayWhile(new SpeakerPlayable(clickhere));
	}
}