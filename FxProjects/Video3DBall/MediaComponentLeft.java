import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.PerspectiveTransformBuilder;
import javafx.scene.layout.Region;
import javafx.scene.media.MediaBuilder;
import javafx.scene.media.MediaPlayerBuilder;
import javafx.scene.media.MediaViewBuilder;

public class MediaComponentLeft extends Region {

	private String mediaSourceURL;
	private boolean visible; // true

	private double mediaViewWidth; // vidWidth
	private double mediaViewHeight; // vidHeight

	private boolean staticControlBar; // false
	private boolean mediaPlayerAutoPlay; // true
	private double volume; // 1.0
	private String mediaDescriptionStr = "A well-tempered rabbit finds his day spoiled by the rude actions of the...";
	private String mediaDurationStr = "9:56";
	private String mediaTitleStr = "Big Buck Bunny";

	public MediaComponentLeft(SimpleDoubleProperty VX, SimpleDoubleProperty VY) {

		setPrefSize(mediaViewWidth, mediaViewHeight);
		setTranslateX(0);
		setTranslateY(0);

		PerspectiveTransform persTrans = PerspectiveTransformBuilder.create()
				.build();

		persTrans.ulxProperty().set(0);
		persTrans.ulyProperty().set(0);
		persTrans.urxProperty().bind(VX);
		persTrans.uryProperty().set(0);
		persTrans.lrxProperty().bind(VX);
		persTrans.lryProperty().bind(VY);
		persTrans.llxProperty().set(0);
		persTrans.llyProperty().set(576);

		setEffect(persTrans);

		getChildren()
				.addAll(MediaViewBuilder
						.create()
						.mediaPlayer(
								MediaPlayerBuilder
										.create()
										.media(MediaBuilder
												.create()
												.source("http://sun.edgeboss.net/download/sun/media/1460825906/1460825906_2956241001_big-buck-bunny-640x360.flv")
												.build()).autoPlay(true)
										.volume(1.0).build()).build());
	}
}
