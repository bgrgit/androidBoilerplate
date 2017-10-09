package com.androidboilerplate.interfaces;

import android.content.DialogInterface;

/**
 * Created by NSM Services on 8/18/16.
 */
public interface OnDialogListner {

    public void onPositiveButtonClick(String whichDialog);
    public void onNegativeButtonClick(DialogInterface dialog);

}
