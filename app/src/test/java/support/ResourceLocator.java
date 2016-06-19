package support;

import android.graphics.drawable.Drawable;

import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;

public class ResourceLocator
{
    public static String getString( int stringId )
    {
        return RuntimeEnvironment.application.getString( stringId );
    }

    public static Drawable getDrawable( int drawableId )
    {
        return RuntimeEnvironment.application.getResources()
                .getDrawable( drawableId );
    }
}