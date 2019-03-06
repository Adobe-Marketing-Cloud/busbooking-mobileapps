/*************************************************************************
 * ADOBE CONFIDENTIAL
 * ___________________
 *
 *  Copyright 2018 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by all applicable intellectual property
 * laws, including trade secret and copyright laws.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/
package com.adobe.busbooking;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * This activity class is responsible to show offer details
 */
public class OfferDetailsActivity extends AppCompatActivity {

    private Handler mainHandler;
    private View surpriseView;
    private View imagePresentView;
    private LinearLayout currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);
        setUpToolBar();
        mainHandler = new Handler(getApplicationContext().getMainLooper());

        surpriseView = getLayoutInflater().inflate(R.layout.suprise_layout,
                (ViewGroup) findViewById(android.R.id.content), false);

        imagePresentView = this.findViewById(R.id.image_present);
        currentLayout = this.findViewById(R.id.offer_layout);
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        toolbar.setTitle("Buy 1 Get 1");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSurpriseClickListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setSurpriseClickListener() {
        imagePresentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Surprise!", Toast.LENGTH_SHORT).show();
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        currentLayout.addView(surpriseView);
                        Map<String, String> profileParams = new HashMap<>();
                        profileParams.put("surprisekey1", "surprisevalue1");
                        currentLayout.invalidate();
                    }
                });
                // One-shot.  Remove clicker afterwards.
                imagePresentView.setOnClickListener(null);
            }
        });
    }
}
