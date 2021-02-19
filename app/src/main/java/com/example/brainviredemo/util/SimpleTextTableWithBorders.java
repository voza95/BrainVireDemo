package com.example.brainviredemo.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SimpleTextTableWithBorders extends TableLayout {

    private Context mContext;
    private String[][] mTableContent;
    private int mTextColor, mBorderColor;
    private int mTextViewBorderWidth, mTableBorderWidth;

    public SimpleTextTableWithBorders(Context context, String[][] tableContent) {
        super(context);
        mContext = context;
        mTableContent = tableContent;
        mTextColor = 0xff111111;
        mBorderColor = 0xAA444444;
        mTextViewBorderWidth = 4;
        mTableBorderWidth = mTextViewBorderWidth * 2;
        setupTable();
    }

    private void setupTable() {
        TableRow tableRow;
        TextView textView;

        setStretchAllColumns(true);
        setBackground(borderDrawable(mTableBorderWidth));
        setPadding(mTableBorderWidth, mTableBorderWidth, mTableBorderWidth, mTableBorderWidth);

        for (int currentRow = 0; currentRow < mTableContent.length; currentRow++) {
            tableRow = new TableRow(mContext);

            for (int currentColumn = 0; currentColumn < mTableContent[0].length; currentColumn++) {
                textView = new TextView(mContext);
                textView.setTextColor(mTextColor);
                textView.setBackground(borderDrawable(mTextViewBorderWidth));
                textView.setText(mTableContent[currentRow][currentColumn]);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(0, 6, 0, 6);
                tableRow.addView(textView);
            }
            addView(tableRow);
        }
    }

    private GradientDrawable borderDrawable(int borderWidth) {
        GradientDrawable shapeDrawable = new GradientDrawable();
        shapeDrawable.setStroke(borderWidth, mBorderColor);
        return shapeDrawable;
    }
}
