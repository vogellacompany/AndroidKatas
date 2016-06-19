
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.greenlifesoftware.simple1.BuildConfig;
import com.greenlifesoftware.simple1.R;
import com.greenlifesoftware.simple1.SecondActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.shadows.ShadowToast;

import android.content.Intent;
import android.widget.Button;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MyActivityTest {

	private MainActivity activity;

	@Test
	public void shouldHaveHappySmiles() throws Exception {
		String hello = new MainActivity().getResources().getString(
				R.string.hello_world);
		assertThat(hello, equalTo("Hello world!"));
	}

	@Before
	public void setup()  {
		activity = Robolectric.buildActivity(MainActivity.class)
				.create().get();
	}
	@Test
	public void checkActivityNotNull() throws Exception {
		assertNotNull(activity);
	}
	
	@Test
	public void buttonClickShouldStartNewActivity() throws Exception 
	{
	    Button button = (Button) activity.findViewById( R.id.button2 );
	    button.performClick();
	    Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
	    assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
	}
	
	@Test
	public void testButtonClick() throws Exception {
		MainActivity activity = Robolectric.buildActivity(MainActivity.class)
				.create().get();
		Button view = (Button) activity.findViewById(R.id.button1);
		assertNotNull(view);
		view.performClick();
		assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lala") );
	}

}