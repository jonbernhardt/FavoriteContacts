package bernhardt.favoritecontacts;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDadPhone, btnDadText;
    Button btnMomPhone, btnMomText;
    Button btnGmaPhone,btnGmaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtonClickEvents();
    }

    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the call button for the first contact
         */
        btnDadPhone = (Button) findViewById(R.id.btnDadPhone);
        btnDadPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callContact("+15079933334");
        }
        });

        /**
         *   Set up button click event listener for the text button for the first contact
         */
        btnDadText = (Button) findViewById(R.id.btnDadText);
        btnDadText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("15079933334");
            }
        });


        /**
         *   Set up button click event listener for the call button for the second contact
         */
        btnMomPhone = (Button) findViewById(R.id.btnMomPhone);
        btnMomPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callContact("+15079518375");
            }
        });

        /**
         *   Set up button click event listener for the text button for the second contact
         */
        btnMomText = (Button) findViewById(R.id.btnMomText);
        btnMomText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("15079518375");
            }
        });

        /**
         *   Set up button click event listener for the call button for the third contact
         */
        btnGmaPhone = (Button) findViewById(R.id.btnGmaPhone);
        btnGmaPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callContact("+17123305619");
            }
        });

        /**
         *   Set up button click event listener for the text button for the third contact
         */
        btnGmaText = (Button) findViewById(R.id.btnGmaText);
        btnGmaText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("17123305619");
            }
        });
    }

    /**
     * Check if there is an activity to handle the call intent.
     * @param number
     *
     */
    public void callContact (String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    /**
     * Check if there is an activity to handle the text intent.
     * @param number
     */
    public void textContact (String number) {
        Intent textIntent = new Intent(Intent.ACTION_VIEW);
        textIntent.setData(Uri.parse("sms:" + number));
        textIntent.putExtra("sms_body", "Hi there");
        if (textIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(textIntent);
        }
    }
}
