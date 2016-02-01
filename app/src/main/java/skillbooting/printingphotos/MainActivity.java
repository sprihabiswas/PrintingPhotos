package skillbooting.printingphotos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void print(View v)
    {
        doPhotoPrint();
    }

    //This method can be called as the action for a menu item.
    // Note that menu items for actions that are not always supported (such as printing) should be placed in the overflow menu.
    private void doPhotoPrint() {
        PrintHelper photoPrinter = new PrintHelper(this);//can use getActivity() here

        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        /**The class has a single layout option, setScaleMode(), which allows you to print with one of two options:
         *SCALE_MODE_FIT - This option sizes the image so that the whole image is shown within the printable area of the page.
         *SCALE_MODE_FILL - This option scales the image so that it fills the entire printable area of the page.
         * Choosing this setting means that some portion of the top and bottom, or left and right edges of the image is not printed.
         * This option is the default value if you do not set a scale mode.
         Both scaling options for setScaleMode() keep the existing aspect ratio of the image intact.*/

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        //here instead of a fixed drawable, you can use some other image dynamically chosen as per your activity.

        photoPrinter.printBitmap("myLogo.jpg", bitmap);
    }
}
