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

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OfferFragment extends Fragment {

    public static final String TAG = OfferFragment.class.getName();
    private static OfferFragment fragment;

    public static OfferFragment getInstance() {
        if (fragment == null) {
            fragment = new OfferFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offer, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity == null) {
            Log.e(TAG, "Fragment activity null");
            return;
        }
        activity.findViewById(R.id.surpriseBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSurpriseFragment();
            }
        });
    }

    private void openSurpriseFragment() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Log.e(TAG, "Fragment activity null");
            return;
        }
        Fragment surpriseFragment = new SurpriseFragment();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_body, surpriseFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}