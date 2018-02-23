package bernhardt.favoritecontacts;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDadPhone, btnDadText;
    Button btnMomPhone, btnMomText;
    Button btnGmaPhone,btnGmaText;
    Spinner spnDadText, spnMomText, spnGmaText;
    ImageButton ibDad, ibMom, ibGma;
    LinearLayout interact1, interact2, interact3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtonClickEvents();
    }

    private void setupButtonClickEvents() {
        ibDad = (ImageButton) findViewById(R.id.ibDad);
        ibMom = (ImageButton) findViewById(R.id.ibMom);
        ibGma = (ImageButton) findViewById(R.id.ibGrandma);
        interact1 = (LinearLayout) findViewById(R.id.interact1);
        interact2 = (LinearLayout) findViewById(R.id.interact2);
        interact3 = (LinearLayout) findViewById(R.id.interact3);

        /**
         *  Set up click event listener for first contact, will show first contact and hide others
         */
        ibDad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interact1.getVisibility() == View.VISIBLE){
                    interact1.setVisibility(View.GONE);
                } else {
                    interact1.setVisibility(View.VISIBLE);
                    interact2.setVisibility(View.GONE);
                    interact3.setVisibility(View.GONE);
                }
            }
        });

        /**
         *  Set up click event listener for second contact, will show first contact and hide others
         */
        ibMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interact2.getVisibility() == View.VISIBLE){
                    interact2.setVisibility(View.GONE);
                } else {
                    interact1.setVisibility(View.GONE);
                    interact2.setVisibility(View.VISIBLE);
                    interact3.setVisibility(View.GONE);
                }
            }
        });

        /**
         *  Set up click event listener for third contact, will show first contact and hide others
         */
        ibGma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interact3.getVisibility() == View.VISIBLE){
                    interact3.setVisibility(View.GONE);
                } else {
                    interact1.setVisibility(View.GONE);
                    interact2.setVisibility(View.GONE);
                    interact3.setVisibility(View.VISIBLE);
                }
            }
        });

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
        spnDadText = (Spinner) findViewById(R.id.spnDadText) ;
        btnDadText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("15079933334", spnDadText.getSelectedItem().toString());
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
        spnMomText = (Spinner) findViewById(R.id.spnMomText);
        btnMomText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("15079518375" , spnMomText.getSelectedItem().toString());
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
        spnGmaText = (Spinner) findViewById(R.id.spnGmaText);
        btnGmaText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textContact("17123305619",  spnGmaText.getSelectedItem().toString());
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
    public void textContact (String number, String text) {
        Intent textIntent = new Intent(Intent.ACTION_VIEW);
        textIntent.setData(Uri.parse("sms:" + number));
        textIntent.putExtra("sms_body", text);
        if (textIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(textIntent);
        }
    }
}
